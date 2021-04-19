package BunnyFights.States;

import BunnyFights.Entities.Creatures.Player;
import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Tiles.Tile;
import BunnyFights.Worlds.World;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"res/worlds/world.txt");
        handler.setWorld(world);
        player = new Player(handler,100,100);


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
