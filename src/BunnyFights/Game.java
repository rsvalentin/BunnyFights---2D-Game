package BunnyFights;

import BunnyFights.Display.Display;
import BunnyFights.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display ;
    private int width;
    private int height;
    private String title;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }
    public void init() {
        display = new Display(title, width, height);
    }


    public void tick() {

    }


    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);



        bs.show();
        g.dispose();
    }


    public void run() {
        init();
        while(running) {
            tick();
            render();
        }
        stop();
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
