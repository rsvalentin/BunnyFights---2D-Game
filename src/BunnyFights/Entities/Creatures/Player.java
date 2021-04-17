package BunnyFights.Entities.Creatures;

import BunnyFights.Game;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;
    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKetManager().up) {
            y -= 3;
        }
        if (game.getKetManager().down) {
            y += 3;
        }
        if (game.getKetManager().left) {
            x -= 3;
        }
        if (game.getKetManager().right) {
            x += 3;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.heroLeft, (int)x, (int)y,null);
    }
}
