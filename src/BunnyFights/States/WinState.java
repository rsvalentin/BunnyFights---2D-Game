package BunnyFights.States;

import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Ui.ClickListener;
import BunnyFights.Ui.UiImageButton;
import BunnyFights.Ui.UiManager;
import BunnyFights.Ui.UiTextButton;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class WinState extends State {

    private UiManager uiManager;

    public WinState(Handler handler) {
        super(handler);
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        /*
        uiManager.addObject(new UiTextButton((int)(handler.getGame().getWidth() / 2) - 50, 140, 200, 80, "Back to main menu", new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
                State.setState(handler.getGame().menuState);
                // State.setState(new GameState(handler));
            }
        }));

         */

    }

    @Override
    public void tick() {
        //uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        Font myFont = new Font("arial", 1, 70);
        g.setFont(myFont);
        g.setColor(Color.red);
        g.drawString("You won with "+score+" points", handler.getGame().getWidth() / 2 - 420, 350);


        uiManager.render(g);
    }
}