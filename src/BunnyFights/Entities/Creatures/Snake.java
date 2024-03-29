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
    private boolean isDead, heroDead;

    public Snake(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

    }

    @Override
    public void tick() {
        if(isDead) {
            snakeRespawn();
            //return;
        }

       move();
        //update collision bounds location
       bounds.x = (int) x;
       bounds.y = (int) y;

    }

    @Override
    public void render(Graphics g) {
        if(isDead)
            return;
        // Render the snake
        g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        // The snake Rectancle
        /*
        g.setColor(Color.black);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);

         */
    }

    public void die(){
        isDead = true;}

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


    public boolean getDead() {
        return isDead;
    }



    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    public void snakeRespawn(){
        this.x = 0;
        this.y = 0;
    }




}
