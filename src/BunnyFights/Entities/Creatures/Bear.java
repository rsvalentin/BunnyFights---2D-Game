package BunnyFights.Entities.Creatures;

import BunnyFights.Handler;
import BunnyFights.States.GameState;
import BunnyFights.Tiles.Tile;
import BunnyFights.gfx.Assets;

import javax.sql.rowset.spi.XmlReader;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bear extends Creature {

    private BufferedImage image;
    private boolean isDead;

    public Bear(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

    }

    @Override
    public void tick() {
        if(isDead) {
            bearRespawn();
            //return;
        }

        move();
        //update collision bounds location
        bounds.x = (int) x;
        bounds.y = (int) y;

    }

    @Override
    public void render(Graphics g) {
        if(isDead) {
            return;
        }

        g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    public void die(){isDead = true;}

    public void moveToPlayer(Player player) {
        float deltaX = player.getX() - this.getX();
        float deltaY = player.getY() - this.getY();
        float hyp = (float) Math.sqrt(deltaX*deltaX + deltaY*deltaY);

        deltaX /= hyp;
        deltaY /= hyp;

        this.setxMove(deltaX * speed);
        this.setyMove(deltaY * speed);
    }

    public void rotateBear(Player player) {

        if (((player.getX() < (this.getX()+50)) && (player.getX() > (this.getX()-50))) && player.getY() > this.getY()) {
            image = Assets.bearFace;
        }
        else if (player.getX() > (this.getX()+50)) {
            image = Assets.bearRight;
        }
        else {
            image = Assets.bearLeft;
        }

        if (((player.getX() < (this.getX()+50)) && (player.getX() > (this.getX()-50))) && player.getY() < this.getY()) {
            image = Assets.bearBack;
        }
    }

    public void bearPlayerRelation(Player player) {
        tick();
        moveToPlayer(player);
        rotateBear(player);
    }

    public boolean getDead() {
        return isDead;
    }

    public void setDead(boolean imDead) {
        imDead= false;
    }

    public void bearRespawn(){
        this.x = 0;
        this.y = 0;
    }

}
