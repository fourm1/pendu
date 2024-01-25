// À implémenter :
//         - si une même lettre est présente plusieurs fois, il faut l'activer plusieurs fois
//         - appeler le mot caché à chaque fois, et à chaque découverte de lettre, la mettre plusieurs fois

package com.pendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        // Lancer le jeu du pendu ici !

        Scanner clavier = new Scanner(System.in);
        System.out.println("Quel est ton prénom ?");
        String prenom = clavier.nextLine();
        System.out.println("Bonjour " + prenom + " ! Enchanté !");
        System.out.println("-+-+-+-");

        String hiddenWord = getString();
        System.out.println(" ");
        String hyphen = "-".repeat(hiddenWord.length());


        int life = 10;
        int foundLetters = 0;
        int remainingLetters;
        List<String> lettersAlreadyGuessed = new ArrayList<>();

        while (life > 0 && hyphen.contains("-")) {

            System.out.println("Mot à trouver : " + hyphen + "\n");
            Scanner scanner = new Scanner(System.in);

            if (life > 1) {
                System.out.println(life + " vies restantes !");
            } else {
                System.out.println(life + " vie restante !");
            }

            System.out.println("Entrez une lettre : ");
            String letterGuessed = scanner.nextLine();

            if (!lettersAlreadyGuessed.contains(letterGuessed)) {
                if (letterGuessed.matches("[a-z]")) {
                    int verificationGuessedLetter = hiddenWord.indexOf(letterGuessed);

                    if (verificationGuessedLetter == -1) {
                        System.out.println("Perdu ! Malheureusement, " + letterGuessed + " n'est pas une bonne lettre !");
                        life--;
                        lettersAlreadyGuessed.add(letterGuessed);
                    } else {
                        System.out.println("Bravo ! " + letterGuessed + " est une bonne lettre !");
                        lettersAlreadyGuessed.add(letterGuessed);
                        StringBuilder builderHyphen = new StringBuilder(hyphen);

                        for (int i = 0; i < hiddenWord.length(); i++) {
                            if (letterGuessed.equals(String.valueOf(hiddenWord.charAt(i)))) {
                                builderHyphen.setCharAt(i, letterGuessed.charAt(0));
                                hyphen = builderHyphen.toString();
                            }
                        }

                    }
                } else if (letterGuessed.matches("[A-Z]")) {
                    System.out.println("Il n'y a aucune lettre majuscule.");
                } else {
                    System.out.println(letterGuessed + " n'est pas une lettre de l'alphabet latin.");
                }
            } else {
                System.out.println("La lettre " + letterGuessed + " a déjà été demandée !");
            }
        }

        if (hyphen.contains("-") && life == 0) {
            System.out.println("Tu as perdu, " + prenom + ". Le mot mystère était " + hiddenWord + " !");
            System.out.println("Tu feras mieux la prochaine fois.");
        } else {
            System.out.println("Bravo " + prenom + " tu as gagné !\nLe mot était effectivement " + hiddenWord + " !");
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