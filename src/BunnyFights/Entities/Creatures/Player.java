package BunnyFights.Entities.Creatures;

import BunnyFights.Game;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;
    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKetManager().up) {
            yMove = -speed;
        }
        if (game.getKetManager().down) {
            yMove = speed;
        }
        if (game.getKetManager().left) {
            xMove = -speed;
        }
        if (game.getKetManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.heroLeft, (int)x, (int)y, width, height, null);
    }
}
