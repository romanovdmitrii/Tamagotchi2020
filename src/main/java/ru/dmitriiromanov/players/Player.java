package ru.dmitriiromanov.players;

import ru.dmitriiromanov.states.State;

import java.awt.*;
import java.util.ArrayList;

public abstract class Player {
    private static double x = 300;
    private static double y = 240;
    private static final double width = 75;
    private static final double height = 78;

    int speed = 7;

    Image image = getImage();

    public static int count = 0;

    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;

    public static ArrayList<String> listLeft = new ArrayList<>();
    public static ArrayList<String> listRight = new ArrayList<>();
    public static ArrayList<String> listAnimation = new ArrayList<>();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update() {
        if (State.isPetLive()) {
            if (!left && !right) getImage();
            if (up && y > 0) {
                y -= speed * 3.5;
                animationUp();
            }

            if (y <= 240) y += 10;
            if (y > 240) y = 240;
            if (down && y <= 240) {
                y += speed;
                animationDown();
            }
            if (left && x > 0) {
                x -= speed;
                animationLeft();
            }
            if (right && x < 612) {
                x += speed;
                animationRight();
            }
        }
    }

    public abstract void animationLeft();

    public abstract void animationRight();

    public abstract void animationUp();

    public abstract void animationDown();

    public abstract Image getImage();

    public abstract void draw(Graphics2D g);

    public static Rectangle getRectangle() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }
}
