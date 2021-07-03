package BunnyFights;

import BunnyFights.Display.Display;
import BunnyFights.Input.KeyManager;
import BunnyFights.Input.MouseManager;
import BunnyFights.States.*;
import BunnyFights.gfx.Assets;
import BunnyFights.gfx.GameCamera;
import BunnyFights.gfx.ImageLoader;
import BunnyFights.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.security.Key;

public class Game implements Runnable {

    private Display display ;
    private int width;
    private int height;
    private String title;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;

    // States
    public State gameState;
    public State menuState;
    public State aboutState;
    public State winState;

    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // Camera
    private GameCamera gameCamera;

    // Handler
    private Handler handler;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    public void init() {

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        winState = new WinState(handler);
        aboutState = new AboutState(handler);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);

        State.setState(menuState);


    }


    public void tick() {
        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }


    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);

        if (State.getState() != null) {
            State.getState().render(g);
        }

        bs.show();
        g.dispose();
    }


    public void run() {
        init();

        long oldTime = System.nanoTime();   /*!< Retine timpul in nanosecunde aferent frame-ului anterior.*/
        long curentTime;                    /*!< Retine timpul curent de executie.*/

        /// Apelul functiilor Update() & Draw() trebuie realizat la fiecare 16.7 ms
        /// sau mai bine spus de 60 ori pe secunda.

        final int framesPerSecond   = 60; /*!< Constanta intreaga initializata cu numarul de frame-uri pe secunda.*/
        final double timeFrame      = 1000000000 / framesPerSecond; /*!< Durata unui frame in nanosecunde.*/

        while(running) {
            curentTime = System.nanoTime();
            if ((curentTime - oldTime) > timeFrame) {
                tick();
                render();
                oldTime = curentTime;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
