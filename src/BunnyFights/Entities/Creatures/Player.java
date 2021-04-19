package BunnyFights.Entities.Creatures;

import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private BufferedImage image;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        image = Assets.heroLeft;
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        if(handler.getKeyManager().left == true)
        {
            image = Assets.heroLeft;
        }
        if(handler.getKeyManager().right == true) {
            image = Assets.heroRight;
        }
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
        g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
