package ru.dmitriiromanov.players;

import ru.dmitriiromanov.states.State;
import ru.dmitriiromanov.states.StatePet;

import javax.swing.*;
import java.awt.*;

public class Food {
    static Image image;

    static Image foodForFrog = new ImageIcon("src/main/resources/frog/eat.jpg").getImage();
    static Image foodForFox = new ImageIcon("src/main/resources/fox/eat.png").getImage();
    static Image foodForOwl = new ImageIcon("src/main/resources/owl/eat.png").getImage();

    public static boolean checkFoot;

    static double x = 450;
    static double y = 10;
    static double width = 50;
    static double height = 50;

    public static void update() {
        if (y <= 270) y += 5;
    }

    public static void getImage() {
        StatePet.getPet();
        if (State.pets == State.PETS.FROG)
            image = new ImageIcon(foodForFrog).getImage();

        if (State.pets == State.PETS.FOX) {
            image = new ImageIcon(foodForFox).getImage();
        }
        if (State.pets == State.PETS.OWL)
            image = new ImageIcon(foodForOwl).getImage();

    }

    public static void draw(Graphics2D g){
        g.drawImage(image, (int) x, (int) y, null);
    }

    public static Rectangle getRectangle() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }
}
