package BunnyFights.Entities.Creatures;

import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Tiles.Tile;
import BunnyFights.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private BufferedImage image;
    private boolean isDeadr;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        image = Assets.heroLeft;

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

    }

    @Override
    public void tick() {
        if (isDeadr) {

        }
        getInput();
        move();
        //bounds.x = (int) x;
        //bounds.y = (int) y;
        handler.getGameCamera().centerOnEntity(this);
        if(handler.getKeyManager().left == true)
        {
            image = Assets.heroLeft;
        }
        if(handler.getKeyManager().right == true) {
            image = Assets.heroRight;
        }

        //System.out.println("x = " + this.getX() + "y = " + this.getY());

    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {

        if (isDeadr) {
            return;
        }
        g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);

        /*
        g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);

         */


    }

    public void die() {
        isDeadr = true;
    }



    //public Rectangle getBounds() {
        //return bounds;
    //}
}
