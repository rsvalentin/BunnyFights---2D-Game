package BunnyFights;


import BunnyFights.Display.Display;

// This class launches the game
public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("BunnyFights", 900,500);
        game.start();
    }
}
