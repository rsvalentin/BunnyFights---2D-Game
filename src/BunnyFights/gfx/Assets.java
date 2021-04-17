package BunnyFights.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage grass, water, tree, hole, island, bush, home;
    public static BufferedImage heroRight, heroLeft;
    public static BufferedImage snakeRight, snakeFace, snakeBack, snakeLeft;
    public static BufferedImage bearRight, bearFace, bearBack, bearLeft;
    public static BufferedImage foxRight, foxFace, foxBack, foxLeft;
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        grass = sheet.crop(0,0, width, height);
        water = sheet.crop(width,0, width, height);
        tree = sheet.crop(2 * width, height, width, height);
        hole = sheet.crop(3 * width,height, width, height);
        island = sheet.crop(4 * width,0, width, height);
        bush = sheet.crop(5 * width,height, width, height);
        home = sheet.crop(6 * width,height, width, height);
        heroRight = sheet.crop(0,height, width, height);
        heroLeft = sheet.crop(width,height, width, height);
        snakeRight = sheet.crop(0 * width,2 * height, width, height);
        snakeFace = sheet.crop(1 * width,2 * height, width, height);
        snakeBack = sheet.crop(2 * width,2 * height, width, height);
        snakeLeft = sheet.crop(3 * width,2 * height, width, height);
        bearRight = sheet.crop(0 * width,3 * height, width, height);
        bearFace = sheet.crop(1 * width,3 * height, width, height);
        bearBack = sheet.crop(2 * width,3 * height, width, height);
        bearLeft = sheet.crop(3 * width,3 * height, width, height);
        foxRight = sheet.crop(0 * width,4 * height, width, height);
        foxFace = sheet.crop(1 * width,4 * height, width, height);
        foxBack = sheet.crop(2 * width,4 * height, width, height);
        foxLeft = sheet.crop(3 * width,4 * height, width, height);
    }
}
