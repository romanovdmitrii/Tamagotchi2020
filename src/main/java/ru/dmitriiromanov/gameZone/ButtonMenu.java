package ru.dmitriiromanov.gameZone;

import javax.swing.*;
import java.awt.*;

public class ButtonMenu{
    double x;
    double y;
    double width;
    double height;

    Color color;

    String nameButton;

    public String addressImage;

    public ButtonMenu(int x, int y, int width, int height, String addressImage, String nameButton) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.addressImage = addressImage;
        this.nameButton = nameButton;
        color = Color.darkGray;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getW() {
        return this.width;
    }

    public double getH() {
        return this.height;
    }

    public void draw(Graphics2D g) {
        g.drawImage(new ImageIcon(addressImage).getImage(), (int) x, (int) y, null);
        g.setColor(color);
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);

        long length = (int) g.getFontMetrics().getStringBounds(nameButton, g).getWidth();
        g.drawString(nameButton, (int) (x + width / 2) - (int) (length / 2), (int) y + (int) (height / 3) * 2);
    }
}
