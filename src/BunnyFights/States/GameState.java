package BunnyFights.States;

import BunnyFights.Entities.Creatures.Player;
import BunnyFights.Game;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game,100,100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
