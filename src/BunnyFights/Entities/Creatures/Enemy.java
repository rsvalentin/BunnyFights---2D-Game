package BunnyFights.Entities.Creatures;

import BunnyFights.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Creature {


    public Enemy(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
    }

}
