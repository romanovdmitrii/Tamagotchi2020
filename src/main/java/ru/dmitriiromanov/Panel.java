package ru.dmitriiromanov;

import ru.dmitriiromanov.players.*;
import ru.dmitriiromanov.states.State;
import ru.dmitriiromanov.gameZone.GameMenu;
import ru.dmitriiromanov.gameZone.MainMenu;
import ru.dmitriiromanov.gameZone.PlayingField;
import ru.dmitriiromanov.states.StateEat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static int mouseX;
    public static int mouseY;

    public enum STATES {MENU, MENUPLAYERS, PLAYDAY, PLAYMORNING, PLAYEVENING, PLAYNIGHT} // фоны игры

    public static STATES state = STATES.MENU;

    private final BufferedImage bufferedImage;
    private final Graphics2D graphics2D;

    Frog frog = new Frog();
    Fox fox = new Fox();
    Owl owl = new Owl();

    Panel() {
        super();
        setFocusable(true);
        requestFocus();

        bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D) bufferedImage.getGraphics();
        addMouseListener(new Listeners());
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
        Timer timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (state.equals(STATES.MENU)) {
            Background.draw(graphics2D);
            MainMenu.draw(graphics2D);

            MainMenu.usingButton(MainMenu.buttonPlay);
            MainMenu.usingButton(MainMenu.buttonReset);
            MainMenu.usingButton(MainMenu.buttonExit);
            gameDraw();
        }
        if (state.equals(STATES.MENUPLAYERS)) {
            Background.draw(graphics2D);
            GameMenu.draw(graphics2D);

            GameMenu.usingButton(GameMenu.buttonPetFrog);
            GameMenu.usingButton(GameMenu.buttonPetFox);
            GameMenu.usingButton(GameMenu.buttonPetOwl);
            gameDraw();
        }
        if (state.equals(STATES.PLAYDAY) || state.equals(STATES.PLAYNIGHT) ||
                state.equals(STATES.PLAYMORNING) || state.equals(STATES.PLAYEVENING)) {

            Background.draw(graphics2D);
            PlayingField.draw(graphics2D);

            PlayingField.usingButton(PlayingField.mainMenu);
            PlayingField.usingButton(PlayingField.buttonEat);
            PlayingField.usingButton(PlayingField.buttonExit);
            gameRender();
            gameDraw();
        }
    }

    public void gameRender() {
        if (State.pets.equals(State.PETS.FROG)) {
            frog.draw(graphics2D);
            frog.update();

        }
        if (State.pets.equals(State.PETS.FOX)) {
            fox.draw(graphics2D);
            fox.update();
        }
        if (State.pets.equals(State.PETS.OWL)) {
            owl.draw(graphics2D);
            owl.update();
        }
        if (Food.checkFoot) {
            Food.update();
            Food.draw(graphics2D);
            if (Frog.getRectangle().intersects(Food.getRectangle())) {
                StateEat.writingInfoAboutEat();  // при соприкосновении персонажа с едой,
                Food.checkFoot = false;          // обновляется дата кормления и еда пропадает
            }
            if (Fox.getRectangle().intersects(Food.getRectangle())) {
                StateEat.writingInfoAboutEat();
                Food.checkFoot = false;
            }
            if (Owl.getRectangle().intersects(Food.getRectangle())) {
                StateEat.writingInfoAboutEat();
                Food.checkFoot = false;
            }
        }
    }

    private void gameDraw() {
        Graphics2D graphics = (Graphics2D) this.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.dispose();
    }
}
