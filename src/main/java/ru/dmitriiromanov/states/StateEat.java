package ru.dmitriiromanov.states;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class StateEat extends State {

    public static void writingInfoAboutEat() {
        try {
            fileWriter = new FileWriter(thePathToTheFileCheckEat);
            fileWriter.write(dtf.format(localDateTime = LocalDateTime.now()));
            setPetEat(true);
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
    public static boolean infoAboutEat(){
        File file = new File(thePathToTheFileCheckEat);
        return file.length() != 0;
    }
}
