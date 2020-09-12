package ru.dmitriiromanov.gameZone;

import ru.dmitriiromanov.Panel;
import ru.dmitriiromanov.states.*;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public static boolean click = false;

    static String buttonPathNormalState = "src/main/resources/buttons/buttonBlue.png";
    static String buttonPathUseState = "src/main/resources/buttons/buttonRed.png";

    public static ButtonMenu buttonPlay
            = new ButtonMenu(250, 110, 197, 37, buttonPathNormalState, "Играть");
    public static ButtonMenu buttonReset
            = new ButtonMenu(250, 160, 197, 37, buttonPathNormalState, "Новая игра");
    public static ButtonMenu buttonExit
            = new ButtonMenu(250, 210, 197, 37, buttonPathNormalState, "Выход");

    public static void draw(Graphics2D graphics2D) {
        buttonPlay.draw(graphics2D);
        buttonReset.draw(graphics2D);
        buttonExit.draw(graphics2D);
    }

    public static void usingButton(ButtonMenu button) {
        if (Panel.mouseX > button.getX() && Panel.mouseX < button.getX() + button.getW() &&
                Panel.mouseY > button.getY() && Panel.mouseY < button.getY() + button.getH()) {
            button.addressImage = buttonPathUseState;

            if (button.equals(buttonPlay)) {
                if (MainMenu.click) {

                    if (StateTime.loginCheck()) { // true = первый вход
                        Panel.state = Panel.STATES.MENUPLAYERS;
                    } else {
                        State.checkInfoState();  // проверка состояния персонажа
                        if (State.isPetLive()) {
                            StatePet.getPet();
                            StateTime.authorizationAboutTheTimeOfEnteringTheGame();
                            StateTime.getTimeOfDay();
                        } else {
                            StateDead.writingInfoAboutDead(); // запись о смерти
                            StateDead.checkNewGame();

                            if (StateDead.getStartInNewGame() > 0) {
                                JOptionPane.showMessageDialog(null, "Game over");
                                JOptionPane.showMessageDialog(null, "Следующая игра " +
                                        "начнется через " + StateDead.getStartInNewGame() + " минут");
                                StatePet.getPet();
                                StateTime.getTimeOfDay();
                            } else {
                                State.reset(); // новая игра
                                Panel.state = Panel.STATES.MENUPLAYERS;
                            }

                        }
                    }
                    MainMenu.click = false;
                }
            }
            if (button.equals(buttonReset)) { // удобно тестить, ну и для тех кто не любит ждать
                if (MainMenu.click) {
                    State.reset();
                    JOptionPane.showMessageDialog(null, "Данные удалены");
                    MainMenu.click = false;
                }
            }
            if (button.equals(buttonExit)) {
                if (MainMenu.click) {
                    System.exit(0);
                    MainMenu.click = false;
                }
            }
        } else {
            button.addressImage = buttonPathNormalState;
        }
    }
}
