package BunnyFights.States;

import BunnyFights.Entities.Creatures.*;
import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Tiles.Tile;
import BunnyFights.Worlds.World;
import BunnyFights.gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {

    private Player player;
    private World world;
    private Snake snake1;
    private Snake snake2;
    private Snake snake3;
    private Snake snake4;
    private Snake snake5;
    private Snake snake6;
    private Snake snake7;
    private Snake snake8;
    private Fox fox1;
    private Fox fox2;
    private Fox fox3;
    private Fox fox4;
    private Bear bear1;
    private Bear bear2;
    private Bear bear3;
    private Bear bear4;
    private Gun gun;

    private int snake1Life = 4;
    private int snake2Life = 4;
    private int snake3Life = 4;
    private int snake4Life = 4;
    private int snake5Life = 4;
    private int snake6Life = 4;
    private int snake7Life = 4;
    private int snake8Life = 4;
    private int fox1Life = 4;
    private int fox2Life = 4;
    private int fox3Life = 4;
    private int fox4Life = 4;
    private int bear1Life = 4;
    private int bear2Life = 4;
    private int bear3Life = 4;
    private int bear4Life = 4;
    public boolean allDead;
    //private int score = 0;
    private ArrayList<Creature> arr = new ArrayList<>(16);

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"res/worlds/world.txt");
        handler.setWorld(world);
        player = new Player(handler,300,300);
        snake1 = new Snake(handler, 100, 100);
        snake2 = new Snake(handler, 300, 200);
        snake3 = new Snake(handler, 500, 500);
        snake4 = new Snake(handler, 600, 600);
        snake5 = new Snake(handler, 3700, 5300);
        snake6 = new Snake(handler, 3500, 5200);
        snake7 = new Snake(handler, 3600, 5500);
        snake8 = new Snake(handler, 3900, 5700);



        snake1.setSpeed(3.1f);
        snake1.snakePlayerRelation(player);

        snake2.setSpeed(2.9f);
        snake2.snakePlayerRelation(player);
        snake3.setSpeed(2.7f);
        snake3.snakePlayerRelation(player);
        snake4.setSpeed(2.5f);
        snake4.snakePlayerRelation(player);
        snake5.setSpeed(3.1f);
        snake5.snakePlayerRelation(player);
        snake6.setSpeed(2.9f);
        snake6.snakePlayerRelation(player);
        snake7.setSpeed(2.7f);
        snake7.snakePlayerRelation(player);
        snake8.setSpeed(2.5f);
        snake8.snakePlayerRelation(player);

        fox1 = new Fox(handler, 2800, 3800);
        fox1.setSpeed(3.1f);
        fox1.foxPlayerRelation(player);
        fox2 = new Fox(handler, 2900, 3900);
        fox2.setSpeed(2.9f);
        fox2.foxPlayerRelation(player);
        fox3 = new Fox(handler, 3000, 4000);
        fox3.setSpeed(2.7f);
        fox3.foxPlayerRelation(player);
        fox4 = new Fox(handler, 2600, 2600);
        fox4.setSpeed(2.5f);
        fox4.foxPlayerRelation(player);

        bear1 = new Bear(handler, 2600, 900);
        bear1.setSpeed(3.1f);
        bear1.bearPlayerRelation(player);
        bear2 = new Bear(handler, 2700, 1000);
        bear2.setSpeed(3.1f);
        bear2.bearPlayerRelation(player);
        bear3 = new Bear(handler, 2500, 900);
        bear3.setSpeed(3.1f);
        bear3.bearPlayerRelation(player);
        bear4 = new Bear(handler, 3100, 700);
        bear4.setSpeed(3.1f);
        bear4.bearPlayerRelation(player);



        gun = new Gun(handler,player.getX(),player.getY());



    }

    @Override
    public void tick() {
        //fire gun if mouse clicked
        if(handler.getMouseManager().isLeftPressed()){
            gun.fire(player.getX(),player.getY(),handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY());
        }

        world.tick();
        player.tick();
        snake1.snakePlayerRelation(player);

        snake2.snakePlayerRelation(player);
        snake3.snakePlayerRelation(player);
        snake4.snakePlayerRelation(player);
        snake5.snakePlayerRelation(player);
        snake6.snakePlayerRelation(player);
        snake7.snakePlayerRelation(player);
        snake8.snakePlayerRelation(player);
        fox1.foxPlayerRelation(player);
        fox2.foxPlayerRelation(player);
        fox3.foxPlayerRelation(player);
        fox4.foxPlayerRelation(player);
        bear1.bearPlayerRelation(player);
        bear2.bearPlayerRelation(player);
        bear3.bearPlayerRelation(player);
        bear4.bearPlayerRelation(player);


        gun.tick();

        //reduce snake life, if it gets hit by bullet
        //update the score
        for(Bullet b : gun.getBullets()){
            if(b.getBounds().intersects(snake1.getBounds())){
                System.out.println("Bullet collided with snake1");
                b.die();
                score = score + 5;
                snake1Life--;
            }

            else if (b.getBounds().intersects(snake2.getBounds())) {
                System.out.println("Bullet collided with snake2");
                b.die();
                score = score + 5;
                snake2Life--;
            }
            else if (b.getBounds().intersects(snake3.getBounds())) {
                System.out.println("Bullet collided with snake3");
                b.die();
                score = score + 5;
                snake3Life--;
            }
            else if (b.getBounds().intersects(snake4.getBounds())) {
                System.out.println("Bullet collided with snake4");
                b.die();
                score = score + 5;
                snake4Life--;
            }
            else if (b.getBounds().intersects(fox1.getBounds())) {
                System.out.println("Bullet collided with fox1");
                b.die();
                score = score + 5;
                fox1Life--;
            }
            else if (b.getBounds().intersects(fox2.getBounds())) {
                System.out.println("Bullet collided with fox2");
                b.die();
                score = score + 5;
                fox2Life--;
            }
            else if (b.getBounds().intersects(fox3.getBounds())) {
                System.out.println("Bullet collided with fox3");
                b.die();
                score = score + 5;
                fox3Life--;
            }
            else if (b.getBounds().intersects(fox4.getBounds())) {
                System.out.println("Bullet collided with fox4");
                b.die();
                score = score + 5;
                fox4Life--;
            }
            else if (b.getBounds().intersects(bear1.getBounds())) {
                System.out.println("Bullet collided with bear1");
                b.die();
                score = score + 5;
                bear1Life--;
            }
            else if (b.getBounds().intersects(bear2.getBounds())) {
                System.out.println("Bullet collided with bear2");
                b.die();
                score = score + 5;
                bear2Life--;
            }
            else if (b.getBounds().intersects(bear3.getBounds())) {
                System.out.println("Bullet collided with bear3");
                b.die();
                score = score + 5;
                bear3Life--;
            }
            else if (b.getBounds().intersects(bear4.getBounds())) {
                System.out.println("Bullet collided with bear4");
                b.die();
                score = score + 5;
                bear4Life--;
            }
            else if (b.getBounds().intersects(snake5.getBounds())) {
                System.out.println("Bullet collided with snake5");
                b.die();
                score = score + 5;
                snake5Life--;
            }
            else if (b.getBounds().intersects(snake6.getBounds())) {
                System.out.println("Bullet collided with snake6");
                b.die();
                score = score + 5;
                snake6Life--;
            }
            else if (b.getBounds().intersects(snake7.getBounds())) {
                System.out.println("Bullet collided with snake7");
                b.die();
                score = score + 5;
                snake7Life--;
            }
            else if (b.getBounds().intersects(snake8.getBounds())) {
                System.out.println("Bullet collided with snake8");
                b.die();
                score = score + 5;
                snake8Life--;
            }



        }

        //enemy dies if it lives reaches 0
        if(snake1Life <= 0){
            snake1.die();

        }

        if (snake1.getBounds().intersects(player.getBounds())) {
            //System.out.println("Collided");
           // player.die();
        }


        if(snake2Life <= 0){
            snake2.die();
        }
        if(snake3Life <= 0){
            snake3.die();
        }
        if(snake4Life <= 0){
            snake4.die();
        }
        if(snake5Life <= 0){
            snake5.die();
        }
        if(snake6Life <= 0){
            snake6.die();
        }
        if(snake7Life <= 0){
            snake7.die();
        }
        if(snake8Life <= 0){
            snake8.die();
        }
        if (fox1Life <= 0) {
            fox1.die();
        }
        if (fox2Life <= 0) {
            fox2.die();
        }
        if (fox3Life <= 0) {
            fox3.die();
        }
        if (fox4Life <= 0) {
            fox4.die();
        }
        if (bear1Life <= 0) {
            bear1.die();
        }
        if (bear2Life <= 0) {
            bear2.die();
        }
        if (bear3Life <= 0) {
            bear3.die();
        }
        if (bear4Life <= 0) {
            bear4.die();
        }



    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        snake1.render(g);

        snake2.render(g);
        snake3.render(g);
        snake4.render(g);
        snake5.render(g);
        snake6.render(g);
        snake7.render(g);
        snake8.render(g);
        fox1.render(g);
        fox2.render(g);
        fox3.render(g);
        fox4.render(g);
        bear1.render(g);
        bear2.render(g);
        bear3.render(g);
        bear4.render(g);

        gun.render(g);
        Font myFont = new Font("arial", 1, 30);
        g.setFont(myFont);
        g.setColor(Color.white);
        g.drawString("Your score: "+score, handler.getGame().getWidth() / 2 - 120, 70);
        myFont = new Font("arial", 1, 70);
        g.setFont(myFont);
        g.setColor(Color.green);
        if (score == 320) {
            g.drawString("You won with "+score+" points", handler.getGame().getWidth() / 2 - 480, 350);
        }
    }


}
