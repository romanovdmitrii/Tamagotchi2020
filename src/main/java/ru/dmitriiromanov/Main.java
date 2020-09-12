package ru.dmitriiromanov;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tamagotchi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(new Panel());

        frame.setVisible(true);
    }
}
