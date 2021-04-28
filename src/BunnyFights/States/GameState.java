package BunnyFights.States;

import BunnyFights.Entities.Creatures.Player;
import BunnyFights.Entities.Creatures.Snake;
import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Tiles.Tile;
import BunnyFights.Worlds.World;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;
    private Snake snake1;


    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"res/worlds/world.txt");
        handler.setWorld(world);
        player = new Player(handler,100,300);
        snake1 = new Snake(handler, 100, 200);

        snake1.setSpeed(3.1f);
        snake1.snakePlayerRelation(player);




    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
        snake1.snakePlayerRelation(player);


    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        snake1.render(g);

    }

}
