package ru.dmitriiromanov.gameZone;

import ru.dmitriiromanov.Panel;
import ru.dmitriiromanov.states.State;
import ru.dmitriiromanov.states.StateEat;
import ru.dmitriiromanov.states.StatePet;
import ru.dmitriiromanov.states.StateTime;

import java.awt.*;

public class GameMenu {
    public static boolean click = false;

    static String addressButtonPetFrogNormalState = "src/main/resources/frog/pitSadness.png";
    static String addressButtonPetFoxNormalState = "src/main/resources/fox/foxSadness.png";
    static String addressButtonPetOwlNormalState = "src/main/resources/owl/owlSadness.png";

    static String addressButtonPetFrogUseState = "src/main/resources/frog/pit.png";
    static String addressButtonPetFoxUseState = "src/main/resources/fox/fox.png";
    static String addressButtonPetOwlUseState = "src/main/resources/owl/owl.png";

    public static ButtonMenu buttonPetFrog
            = new ButtonMenu(160, 160, 75, 78, addressButtonPetFrogNormalState, "");
    public static ButtonMenu buttonPetFox
            = new ButtonMenu(310, 160, 75, 78, addressButtonPetFoxNormalState, "");
    public static ButtonMenu buttonPetOwl
            = new ButtonMenu(460, 160, 75, 78, addressButtonPetOwlNormalState, "");

    public static void draw(Graphics2D graphics2D) {
        buttonPetFrog.draw(graphics2D);
        buttonPetFox.draw(graphics2D);
        buttonPetOwl.draw(graphics2D);
    }

    public static void usingButton(ButtonMenu button) {
        if (Panel.mouseX > button.getX() && Panel.mouseX < button.getX() + button.getW() &&
                Panel.mouseY > button.getY() && Panel.mouseY < button.getY() + button.getH()) {

            if (button.equals(buttonPetFrog)) {
                button.addressImage = addressButtonPetFrogUseState;
                if (GameMenu.click) {
                    StateTime.authorizationAboutTheTimeOfEnteringTheGame(); // запись даты входа в игру
                    StateEat.writingInfoAboutEat();                         // запись даты кормления
                    StatePet.selectedPet(State.PETS.FROG);                  // выбор персонажа
                    StateTime.getTimeOfDay();                               // установка background в зависимости
                    GameMenu.click = false;                                 // от времени суток
                }
            }
            if (button.equals(buttonPetFox)) {
                button.addressImage = addressButtonPetFoxUseState;
                if (GameMenu.click) {
                    StateTime.authorizationAboutTheTimeOfEnteringTheGame();
                    StateEat.writingInfoAboutEat();
                    StatePet.selectedPet(StateTime.PETS.FOX);
                    StateTime.getTimeOfDay();
                    GameMenu.click = false;
                }
            }
            if (button.equals(buttonPetOwl)) {
                button.addressImage = addressButtonPetOwlUseState;
                if (GameMenu.click) {
                    StateTime.authorizationAboutTheTimeOfEnteringTheGame();
                    StateEat.writingInfoAboutEat();
                    StatePet.selectedPet(StateTime.PETS.OWL);
                    StateTime.getTimeOfDay();
                    GameMenu.click = false;
                }
            }
        } else {
            if (button.equals(buttonPetFrog)) button.addressImage = addressButtonPetFrogNormalState;
            if (button.equals(buttonPetFox)) button.addressImage = addressButtonPetFoxNormalState;
            if (button.equals(buttonPetOwl)) button.addressImage = addressButtonPetOwlNormalState;
        }
    }
}