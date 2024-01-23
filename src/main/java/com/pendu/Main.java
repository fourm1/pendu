package com.pendu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        // Lancer le jeu du pendu ici !
        String wordsPath = "src/main/java/com/pendu/resource/words.txt";
        List<String> wordsToFind = new ArrayList<>();
        String eachLine;
        Random random = new Random();
        try (BufferedReader reader = new BufferedReader(new FileReader(wordsPath))) {

            while ((eachLine = reader.readLine()) != null) {
                wordsToFind.add(eachLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int randomInt = random.nextInt(30);

        //Test du tableau
        String testWordsToFind = wordsToFind.get(randomInt);
        for (String wordTest : wordsToFind) {
            System.out.println(wordTest);
        }

        System.out.println("------");
        System.out.println(testWordsToFind);
        int count = 0;

        for (int i = 0; i < testWordsToFind.length(); i++) {
            if (testWordsToFind.charAt(i) != ' ') {
                count++;
            }
        }
        System.out.println("Nombre total de caractères du mot-mystère : " + count);
    }
}