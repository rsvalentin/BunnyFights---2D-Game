package BunnyFights.States;

import BunnyFights.Game;
import BunnyFights.Handler;
import BunnyFights.Ui.ClickListener;
import BunnyFights.Ui.UiImageButton;
import BunnyFights.Ui.UiManager;
import BunnyFights.Ui.UiTextButton;
import BunnyFights.gfx.Assets;

import java.awt.*;

public class AboutState extends State {

    private UiManager uiManager;

    public AboutState(Handler handler) {
        super(handler);
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);


    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {

        Font myFont = new Font("arial", 1, 30);
        g.setFont(myFont);
        g.setColor(Color.red);
        g.drawString("About Game", handler.getGame().getWidth() / 2 - 120, 70);


        myFont = new Font("arial", 1, 20);
        g.setFont(myFont);
        g.drawString("Controls: W, A, S, D", handler.getGame().getWidth() / 2 - 480, 130);

        g.drawString("In order to kill the enemies you need to press left key mouse button to shoot with", handler.getGame().getWidth() / 2 - 480, 230);
        g.drawString("carrots", handler.getGame().getWidth() / 2 - 480, 250);
        g.drawString("You need to kill all the enemies to win the game", handler.getGame().getWidth() / 2 - 480, 280);
        g.drawString("Good luck, rabbit!", handler.getGame().getWidth() / 2 - 480, 380);




        myFont = new Font("arial", 1, 50);
        g.setFont(myFont);


        uiManager.render(g);


    }
}