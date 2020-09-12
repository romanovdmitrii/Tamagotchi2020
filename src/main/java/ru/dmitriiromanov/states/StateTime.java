package ru.dmitriiromanov.states;

import ru.dmitriiromanov.Panel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class StateTime extends State {

    public static boolean loginCheck() {
        File file = new File(thePathToTheFileTimeToEnterTheGame);
        return file.length() == 0;
    }

    public static void authorizationAboutTheTimeOfEnteringTheGame() {
        try {
            fileWriter = new FileWriter(thePathToTheFileTimeToEnterTheGame);
            fileWriter.write(dtf.format(localDateTime = LocalDateTime.now()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getTimeOfDay() {
        int hour = localDateTime.getHour();
        if (hour > 5 && hour <= 10) {
            Panel.state = Panel.STATES.PLAYMORNING;
        } else if (hour > 10 && hour <= 17) {
            Panel.state = Panel.STATES.PLAYDAY;
        } else if (hour > 17 && hour <= 20) {
            Panel.state = Panel.STATES.PLAYEVENING;
        } else {
            Panel.state = Panel.STATES.PLAYNIGHT;
        }
    }
}
