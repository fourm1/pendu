package com.pendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lancer le jeu du pendu ici !

        Scanner clavier = new Scanner(System.in);
        System.out.println("Bonjour ! Quel est ton prénom ?");
        String prenom = clavier.nextLine();
        System.out.println("Bonjour " + prenom + " ! Enchanté !");
        System.out.println("------");

        String hiddenWord = getString();
        System.out.println("Mot à trouver : " + "-".repeat(hiddenWord.length()));

        int life = 10;
        int foundLetters = 0;

        while (life > 0 && foundLetters < hiddenWord.length()) {
            Scanner letterGuessed = new Scanner(System.in);
        }
    }

    private static String getString() {
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

        return wordsToFind.get(randomInt);
    }
}