package ru.dmitriiromanov.states;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StatePet extends State {

    public static void selectedPet(PETS pet) {
        try {
            fileWriter = new FileWriter(thePathToTheFileSelectedPet);
            if (pet.equals(StatePet.PETS.FROG)) {
                pets = PETS.FROG;
                fileWriter.write("frog");
            }
            if (pet.equals(StatePet.PETS.FOX)) {
                pets = PETS.FOX;
                fileWriter.write("fox");
            }
            if (pet.equals(StatePet.PETS.OWL)) {
                pets = PETS.OWL;
                fileWriter.write("owl");
            }
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

    public static void getPet() {
        try {
            bufferedReader = new BufferedReader(new FileReader(thePathToTheFileSelectedPet));
            String line = bufferedReader.readLine();

            if (line.equals("frog")) pets = PETS.FROG;
            if (line.equals("fox")) pets = PETS.FOX;
            if (line.equals("owl")) pets = PETS.OWL;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
