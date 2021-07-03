package BunnyFights.States;

import BunnyFights.Game;
import BunnyFights.Handler;

import java.awt.*;

public abstract class State {
    protected int score = 0;
    private static State currentState = null;
    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    // CLASS
    protected Handler handler;
    public State(Handler handler) {
        this.handler = handler;
    }
    public abstract void tick();
    public abstract void render(Graphics g);

}
