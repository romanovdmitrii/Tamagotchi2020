package ru.dmitriiromanov.players;

import ru.dmitriiromanov.states.State;

import javax.swing.*;
import java.awt.*;

public class Owl extends Player {

    @Override
    public void animationLeft() {
        image = new ImageIcon("src/main/resources/owl/owlLeft.png").getImage();
    }

    @Override
    public void animationRight() {
        image = new ImageIcon("src/main/resources/owl/owlRight.png").getImage();
    }

    @Override
    public void animationUp() {
        image = new ImageIcon("src/main/resources/owl/owlUp.png").getImage();
    }

    @Override
    public void animationDown() {
        image = new ImageIcon("src/main/resources/owl/owlDown.png").getImage();
    }

    @Override
    public Image getImage() {
        State.checkInfoState();
        if (State.isPetLive() && State.isPetEat())
            image = new ImageIcon("src/main/resources/owl/owl.png").getImage();
        if (!State.isPetEat())
            image = new ImageIcon("src/main/resources/owl/owlSadness.png").getImage();
        if (!State.isPetLive())
            image = new ImageIcon("src/main/resources/owl/rip.png").getImage();
        return image;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, (int) getX(), (int) getY(), null);
    }

}
