package BunnyFights.Entities.Creatures;

import BunnyFights.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.heroLeft, (int)x, (int)y,null);
    }
}
