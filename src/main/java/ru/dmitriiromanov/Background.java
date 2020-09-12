package ru.dmitriiromanov;

import javax.swing.*;
import java.awt.*;

public class Background {
    private static final Image bgPlayDay = new ImageIcon("src/main/resources/background/bgDay.jpg").getImage();
    private static final Image bgPlayMorning = new ImageIcon("src/main/resources/background/bgMorning.jpg").getImage();
    private static final Image bgPlayEvening = new ImageIcon("src/main/resources/background/bgEvening.jpg").getImage();
    private static final Image bgPlayNight = new ImageIcon("src/main/resources/background/bgNight.jpg").getImage();
    private static final Image bgMenu = new ImageIcon("src/main/resources/background/bgMenu.png").getImage();

    public static void draw(Graphics2D g) {
        if (Panel.state.equals(Panel.STATES.MENU)) g.drawImage(bgMenu, 0, 0, null);
        if (Panel.state.equals(Panel.STATES.MENUPLAYERS)) g.drawImage(bgMenu, 0, 0, null);
        if (Panel.state.equals(Panel.STATES.PLAYDAY)) g.drawImage(bgPlayDay, 0, 0, null);
        if (Panel.state.equals(Panel.STATES.PLAYMORNING)) g.drawImage(bgPlayMorning, 0, 0, null);
        if (Panel.state.equals(Panel.STATES.PLAYEVENING)) g.drawImage(bgPlayEvening, 0, 0, null);
        if (Panel.state.equals(Panel.STATES.PLAYNIGHT)) g.drawImage(bgPlayNight, 0, 0, null);
    }
}
