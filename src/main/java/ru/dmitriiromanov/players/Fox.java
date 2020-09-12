package ru.dmitriiromanov.players;

import ru.dmitriiromanov.states.State;

import javax.swing.*;
import java.awt.*;

public class Fox extends Player {

    @Override
    public void animationLeft() {
        Player.listLeft.add("src/main/resources/fox/foxLeft1.png");
        Player.listLeft.add("src/main/resources/fox/foxLeft2.png");
        count++;
        if (count >= Player.listLeft.size()) count = 0;
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        image = new ImageIcon(Player.listLeft.get(count)).getImage();
    }

    @Override
    public void animationRight() {
        Player.listRight.add("src/main/resources/fox/foxRight1.png");
        Player.listRight.add("src/main/resources/fox/foxRight2.png");
        count++;
        if (count >= Player.listRight.size()) count = 0;
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        image = new ImageIcon(Player.listRight.get(count)).getImage();
    }

    @Override
    public void animationUp() {
        image = new ImageIcon("src/main/resources/fox/foxUp.png").getImage();
    }

    @Override
    public void animationDown() {
        image = new ImageIcon("src/main/resources/fox/foxDown.png").getImage();
    }

    @Override
    public Image getImage() {
        State.checkInfoState();
        if (State.isPetLive() && State.isPetEat())
            image = new ImageIcon("src/main/resources/fox/fox.png").getImage();
        if (!State.isPetEat())
            image = new ImageIcon("src/main/resources/fox/foxSadness.png").getImage();
        if (!State.isPetLive())
            image = new ImageIcon("src/main/resources/fox/rip.png").getImage();
        return image;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, (int) getX(), (int) getY(), null);
    }

}
