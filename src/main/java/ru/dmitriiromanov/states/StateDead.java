package ru.dmitriiromanov.states;

import java.io.*;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.HOURS;

public class StateDead extends State {

    private static final int ban = 5;
    private static int startInNewGame = 0;

    public static int getStartInNewGame() {
        return startInNewGame;
    }

    public static void writingInfoAboutDead() {
        try {
            fileWriter = null;
            if (!infoAboutDead()) {
                fileWriter = new FileWriter(thePathToTheFileCheckDead);
                fileWriter.write(dtf.format(localDateTime = LocalDateTime.now()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkNewGame() {
        try {
            bufferedReader = null;
            if (StateEat.infoAboutEat()) {
                bufferedReader = new BufferedReader(new FileReader(thePathToTheFileCheckDead));
                String line = bufferedReader.readLine();
                if (!line.isEmpty()) {
                    LocalDateTime dateTime = LocalDateTime.parse(line, dtf);
                    startInNewGame = ban - (int) HOURS.between(dateTime, localDateTime = LocalDateTime.now());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean infoAboutDead() {
        File file = new File(thePathToTheFileCheckDead);
        return file.length() != 0;
    }
}
