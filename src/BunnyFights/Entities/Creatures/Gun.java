package BunnyFights.Entities.Creatures;

import BunnyFights.Entities.Entity;
import BunnyFights.Handler;

import java.awt.*;
import java.util.ArrayList;

public class Gun extends Entity {

    private ArrayList<Bullet> bullets;
    private int bulletWidth = 25,bulletHeight = 25;

    private int fireCoolDown = 20;//player can fire after every 80 ticks
    private int timer;
    private boolean canFire;

    public Gun(Handler handler, float x, float y) {
        super(handler, x, y, 0,0);

        bullets = new ArrayList<Bullet>();
    }

    @Override
    public void tick() {

        //counting fire cool down time, if cannot fire
        if(!canFire) {
            timer++;
            if (timer >= fireCoolDown) {
                timer = 0;
                canFire = true;
            }
        }
        for(Bullet bullet : bullets)
            bullet.tick();

        //remove dead bullets
        for(int i = bullets.size() - 1; i >= 0; i--)
            if(bullets.get(i).isDead())
                bullets.remove(i);
    }

    @Override
    public void render(Graphics g) {
    for(Bullet bullet : bullets)
        bullet.render(g);
    }

    public void fire(float x,float y,int dx,int dy){
        if(!canFire)
            return;

        Bullet b = new Bullet(handler,x,y,bulletWidth,bulletHeight,dx,dy);
        bullets.add(b);
        canFire = false;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
