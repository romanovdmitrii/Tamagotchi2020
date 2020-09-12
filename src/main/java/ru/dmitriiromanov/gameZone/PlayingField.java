package ru.dmitriiromanov.gameZone;

import ru.dmitriiromanov.Panel;
import ru.dmitriiromanov.players.Food;

import java.awt.*;

public class PlayingField {
    public static boolean click = false;

    static String buttonPathNormalState = "src/main/resources/buttons/buttonGreen.png";
    static String buttonPathUseState = "src/main/resources/buttons/buttonYellow.png";
    static String buttonPathUseRED = "src/main/resources/buttons/buttonRed.png";

    public static ButtonMenu mainMenu
            = new ButtonMenu(25, 320, 197, 37, buttonPathNormalState, "Главное меню");
    public static ButtonMenu buttonEat
            = new ButtonMenu(250, 320, 197, 37, buttonPathNormalState, "Покормить");
    public static ButtonMenu buttonExit
            = new ButtonMenu(475, 320, 197, 37, buttonPathNormalState, "Выход");


    public static void draw(Graphics2D graphics2D) {
        mainMenu.draw(graphics2D);
        buttonEat.draw(graphics2D);
        buttonExit.draw(graphics2D);
    }

    public static void usingButton(ButtonMenu button) {
        if (Panel.mouseX > button.getX() && Panel.mouseX < button.getX() + button.getW() &&
                Panel.mouseY > button.getY() && Panel.mouseY < button.getY() + button.getH()) {

            if (button.equals(mainMenu)) {
                button.addressImage = buttonPathUseState;
                if (click) {
                    Panel.state = Panel.STATES.MENU;  // выход в главное меню
                    click = false;
                }
            }
            if (button.equals(buttonEat)) {
                button.addressImage = buttonPathUseState;
                if (click) {
                    Food.getImage();        // кормим персонажа
                    Food.checkFoot = true;
                    click = false;
                }
            }
            if (button.equals(buttonExit)) {
                button.addressImage = buttonPathUseRED;
                if (click) {
                    System.exit(0);
                    click = false;
                }
            }
        } else {
            if (button.equals(mainMenu)) button.addressImage = buttonPathNormalState;
            if (button.equals(buttonEat)) button.addressImage = buttonPathNormalState;
            if (button.equals(buttonExit)) button.addressImage = buttonPathNormalState;
        }
    }
}
