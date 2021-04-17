package BunnyFights.Entities.Creatures;

import BunnyFights.Entities.Entity;

public abstract class Creature extends Entity {

    protected int health;
    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }
}
