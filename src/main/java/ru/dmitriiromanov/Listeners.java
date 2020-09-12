package ru.dmitriiromanov;

import ru.dmitriiromanov.gameZone.GameMenu;
import ru.dmitriiromanov.gameZone.MainMenu;
import ru.dmitriiromanov.gameZone.PlayingField;
import ru.dmitriiromanov.players.Player;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENU) {
                MainMenu.click = true;
            }
            if (Panel.state == Panel.STATES.MENUPLAYERS) {
                GameMenu.click = true;
            }
            if (Panel.state == Panel.STATES.PLAYDAY || Panel.state == Panel.STATES.PLAYNIGHT ||
                    Panel.state == Panel.STATES.PLAYMORNING || Panel.state == Panel.STATES.PLAYEVENING) {

                PlayingField.click = true;
            }
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENU) {
                MainMenu.click = false;
            }
            if (Panel.state == Panel.STATES.MENUPLAYERS) {
                GameMenu.click = false;
            }
            if (Panel.state == Panel.STATES.PLAYDAY || Panel.state == Panel.STATES.PLAYNIGHT ||
                    Panel.state == Panel.STATES.PLAYMORNING || Panel.state == Panel.STATES.PLAYEVENING) {

                PlayingField.click = false;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();
        Panel.mouseY = e.getY();
    }
}
