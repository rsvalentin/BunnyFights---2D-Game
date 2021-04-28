package BunnyFights.Entities.Creatures;

import BunnyFights.Handler;
import BunnyFights.States.GameState;
import BunnyFights.Tiles.Tile;
import BunnyFights.gfx.Assets;

import javax.sql.rowset.spi.XmlReader;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Snake extends Creature {


    public Snake(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {



       move();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.snakeFace, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    public void moveToPlayer(Player player) {
        float deltaX = player.getX() - this.getX();
        float deltaY = player.getY() - this.getY();
        float hyp = (float) Math.sqrt(deltaX*deltaX + deltaY*deltaY);

        deltaX /= hyp;
        deltaY /= hyp;

        this.setxMove(deltaX * speed);
        this.setyMove(deltaY * speed);
    }
}
