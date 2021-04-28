package BunnyFights.Entities.Creatures;

import BunnyFights.Handler;
import BunnyFights.States.GameState;
import BunnyFights.Tiles.Tile;
import BunnyFights.gfx.Assets;

import javax.sql.rowset.spi.XmlReader;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Snake extends Creature {

    private BufferedImage image;
    public Snake(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

    }

    @Override
    public void tick() {
       move();
      //  handler.getGameCamera().centerOnEntity(this);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
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

    public void rotateSnake(Player player) {

        if (((player.getX() < (this.getX()+50)) && (player.getX() > (this.getX()-50))) && player.getY() > this.getY()) {
            image = Assets.snakeFace;
        }
        else if (player.getX() > (this.getX()+50)) {
            image = Assets.snakeRight;
        }
        else {
            image = Assets.snakeLeft;
        }

        if (((player.getX() < (this.getX()+50)) && (player.getX() > (this.getX()-50))) && player.getY() < this.getY()) {
            image = Assets.snakeBack;
        }
    }

    public void snakePlayerRelation(Player player) {
        tick();
        moveToPlayer(player);
        rotateSnake(player);
    }
}
