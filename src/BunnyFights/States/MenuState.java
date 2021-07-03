package BunnyFights.States;

import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Ui.ClickListener;
import BunnyFights.Ui.UiImageButton;
import BunnyFights.Ui.UiManager;
import BunnyFights.Ui.UiTextButton;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    private UiManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UiTextButton((int)(handler.getGame().getWidth() / 2) - 50, 140, 200, 80, "Start Game", new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
               // State.setState(new GameState(handler));
            }
        }));

        uiManager.addObject(new UiTextButton((int)(handler.getGame().getWidth() / 2) - 50, 240, 200, 80, "About Game", new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().aboutState);
                // State.setState(new GameState(handler));
            }
        }));

        uiManager.addObject(new UiTextButton((int)(handler.getGame().getWidth() / 2) - 50, 340, 200, 80, "Exit", new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);




            }
        }));


    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}