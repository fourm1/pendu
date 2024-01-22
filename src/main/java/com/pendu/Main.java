package com.pendu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lancer le jeu du pendu ici !
        String wordsPath = "/resource/words.txt";
        List<String> wordsToFind = new ArrayList<>();
        String eachLine;

        try (BufferedReader reader = new BufferedReader(new FileReader(wordsPath))) {

            while ((eachLine = reader.readLine()) != null) {
                wordsToFind.add(eachLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Test du tableau
        for (int i = 0; i < eachLine.length(); i++) {
            System.out.println(eachLine);
        }
    }
}