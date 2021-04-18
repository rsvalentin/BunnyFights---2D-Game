package BunnyFights.States;

import BunnyFights.Entities.Creatures.Player;
import BunnyFights.Game;
import BunnyFights.Tiles.Tile;
import BunnyFights.Worlds.World;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game,100,100);
        world = new World(game,"res/worlds/world.txt");


    }

    @Override
    public void tick() {
        world.tick();
        player.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
