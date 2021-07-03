package BunnyFights.Entities.Creatures;

import BunnyFights.Entities.Entity;
import BunnyFights.Handler;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class Bullet extends Entity {


    private float dx, dy;
    private float xSpeed = 1,ySpeed = 1;
    private float speed = 1.5f;
    private boolean isDead;

    public Bullet(Handler handler, float x, float y, int width, int height,int dx,int dy) {
        super(handler, x, y, width, height);

        //destination x and y
        this.dx = dx;
        this.dy = dy;

        //distance from destination
        int distance = distanceFromDestination();

        //set x and y speed
        xSpeed = (dx-x)/distance * speed;
        ySpeed = (dy-y)/distance * speed;
    }

    @Override
    public void tick() {
      if(isDead)
          return;

      //move bullet
       x += xSpeed;
       y += ySpeed;

       //update collision bounds location
        bounds.x = (int) x;
        bounds.y = (int) y;

       //if distance from destination < 1 then, bullet dies
       if(distanceFromDestination() <= 1)
           isDead = true;
    }

    @Override
    public void render(Graphics g) {
        if(isDead)
            return;

        g.setColor(Color.RED);
        g.fillOval((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
        /*
        g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);

         */
    }

    public boolean isDead(){
        return isDead;
    }

    public void die(){isDead = true;}

    private int distanceFromDestination(){
        int distance = (int) Math.sqrt(Math.pow(x - dx,2) + Math.pow(y - dy,2));

        return distance;
    }

}
