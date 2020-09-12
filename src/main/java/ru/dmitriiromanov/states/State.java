package ru.dmitriiromanov.states;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.HOURS;

public abstract class State {
    static BufferedReader bufferedReader;
    static FileWriter fileWriter;

    public enum PETS {FROG, FOX, OWL}

    public static StatePet.PETS pets;

    private static boolean petLive = true;
    private static boolean petEat = true;

    public static long difference = 0;

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("Дата dd.MM.yyyy Время HH:mm");
    public static LocalDateTime localDateTime;

    public static String thePathToTheFileTimeToEnterTheGame = "src/main/resources/textFile/timeToEnterTheGame.txt";
    public static String thePathToTheFileSelectedPet = "src/main/resources/textFile/selectedPet.txt";
    public static String thePathToTheFileCheckDead = "src/main/resources/textFile/checkDead.txt";
    public static String thePathToTheFileCheckEat = "src/main/resources/textFile/checkEat.txt";

    public static boolean isPetLive() {
        return petLive;
    }

    public static void setPetLive(boolean petLive) {
        State.petLive = petLive;
    }

    public static boolean isPetEat() {
        return petEat;
    }

    public static void setPetEat(boolean petEat) {
        State.petEat = petEat;
    }

    public static void checkInfoState() {
        try {
            bufferedReader = null;
            if (StateEat.infoAboutEat()) {
                bufferedReader = new BufferedReader(new FileReader(thePathToTheFileCheckEat));
                String line = bufferedReader.readLine();
                if (!line.isEmpty()) {
                    LocalDateTime dateTime = LocalDateTime.parse(line, dtf);
                    difference = HOURS.between(dateTime, localDateTime = LocalDateTime.now());
                }
            }

            if (!StateDead.infoAboutDead()) {
                if (difference <= 3)
                    setPetEat(true);
                if (difference > 3 && difference <= 7)
                    setPetEat(false);
                if (difference > 7)
                    setPetLive(false);
            } else
                setPetLive(false);

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

    public static void reset() {
        try {
            new FileWriter(thePathToTheFileTimeToEnterTheGame).close();
            new FileWriter(thePathToTheFileSelectedPet).close();
            new FileWriter(thePathToTheFileCheckDead).close();
            new FileWriter(thePathToTheFileCheckEat).close();
            setPetLive(true);
            setPetEat(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
