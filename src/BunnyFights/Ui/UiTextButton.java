package BunnyFights.Ui;

import java.awt.*;

public class UiTextButton extends UiObject {

    String buttonName;
    private ClickListener clicker;

    public UiTextButton(float x, float y, int width, int height, String buttonName, ClickListener clicker){
        super(x, y, width, height);
        this.buttonName = buttonName;
        this.clicker = clicker;
    }


    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        //g.drawRect((int)x, (int)y, width, height);
        if(hovering){
            g.drawString(buttonName, (int)x+5, (int)y+45);
        }else{
            g.drawString(buttonName, (int)x, (int)y+40);
            //g.drawImage(Assets.player_down[0], (int)x, (int)y, width, height, null);
        }

    }

    @Override
    public void onClick(){
        clicker.onClick();
    }

}
