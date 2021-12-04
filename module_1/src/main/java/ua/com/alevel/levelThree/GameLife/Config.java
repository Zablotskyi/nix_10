package ua.com.alevel.levelThree.GameLife;

import java.awt.*;

public class Config {

    public static final int SIZE = 10;
    public int width;
    public int height;
    public static final int SLEEPMS = 100;

    public Config(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static Color getColor(Status status) {
        switch (status) {
            default:
            case NONE: {
                return Color.BLACK;
            }
            case BORN: {
                return Color.GRAY;
            }
            case LIVE: {
                return Color.WHITE;
            }
            case DIED: {
                return Color.GRAY;
            }
        }
    }
}
