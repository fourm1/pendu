// Bug : la même lettre peut être appelée plusieurs fois et peut permettre de faire remporter la victoire

// À implémenter :
//         - si une même lettre est présente plusieurs fois, il faut l'activer plusieurs fois
//         - appeler le mot caché à chaque fois, et à chaque découverte de lettre, la mettre plusieurs fois

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
        System.out.println("Quel est ton prénom ?");
        String prenom = clavier.nextLine();
        System.out.println("Bonjour " + prenom + " ! Enchanté !");
        System.out.println("------");

        String hiddenWord = getString();
        System.out.println(" ");
        System.out.println(hiddenWord);
        String hyphen = "-".repeat(hiddenWord.length());
        System.out.println("Mot à trouver : " + hyphen);
        System.out.println(" ");

        int life = 10;
        int foundLetters = 0;
        int remainingLetters;

        while (life > 0 && foundLetters < hiddenWord.length()) {
            Scanner scanner = new Scanner(System.in);

            if (life > 1) {
                System.out.println(life + " vies restantes !");
            } else {
                System.out.println(life + " vie restante !");
            }

            System.out.println("Entrez une lettre : ");
            String letterGuessed = scanner.nextLine();

            if (letterGuessed.matches("[a-z]")) {
                int verificationGuessedLetter = hiddenWord.indexOf(letterGuessed);

                if (verificationGuessedLetter == -1) {
                    System.out.println("Perdu ! Malheureusement, " + letterGuessed + " n'est pas une bonne lettre !");
                    life--;
                } else {
                    System.out.println("Bravo ! " + letterGuessed + " est une bonne lettre !");
                    foundLetters++;
                    remainingLetters = hiddenWord.length() - foundLetters;
                    System.out.println("Il vous reste " + remainingLetters + " lettres à trouver !");
                }

            } else if (letterGuessed.matches("[A-Z]")) {
                System.out.println("Il n'y a aucune lettre majuscule.");

            } else {
                System.out.println(letterGuessed + " n'est pas une lettre de l'alphabet latin.");
            }
        }

        if (foundLetters == hiddenWord.length()) {
            System.out.println("Bravo " + prenom + " tu as gagné !");
        } else if (life == 0) {
            System.out.println("Tu as perdu, " + prenom + ". Le mot mystère était " + hiddenWord + " !");
            System.out.println("Tu feras mieux la prochaine fois.");
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