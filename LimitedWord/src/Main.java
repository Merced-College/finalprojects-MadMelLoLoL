// Madison Bazan
// 7/18/2025

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> wordList = WordsLetterGen.loadWords("words.txt");
        Set<String> validWords = new HashSet<>(wordList); // **ai line

        
        Set<String> allCombos = new HashSet<>(); // ** ai gen: Set to hold all letter combinations
        for (int length = 1; length <= 3; length++) { // **ai loop: Generate combinations for lengths 1 to 3
            allCombos.addAll(WordsLetterGen.extractLetterCombinations(wordList, length));
        }

        Scanner scnr = new Scanner(System.in);
        int totalScore = 0;
        int lives = 3;

        String targetCombo = WordsLetterGen.getRandomCombo(allCombos); // **Pick once per round

        //game loop
        while (lives > 0) { // **ai helped me place the while loop properly
            if (targetCombo.isEmpty()) {
                System.out.println("No letter combinations available. Game cannot continue.");
                break;
            }
            System.out.println("Type a word that contains: " + targetCombo);
            System.out.println("You have " + lives + " lives. Good luck!");

            String playerInput = scnr.nextLine();

            int length = playerInput.length();
            int score = points.getScore(length); //points based on length (3 levels)

            //game results
            if (playerInput.isEmpty()) {
                System.out.println("❌ You didn't type anything! :( Try again. " + totalScore);
                break;
            } else if (WordsLetterGen.isValidWord(playerInput, targetCombo, validWords)) {
                totalScore += score;
                System.out.println("✅ Correct!");
                System.out.println("Your word has " + length + " letters. Your score is now " + totalScore);
                targetCombo = WordsLetterGen.getRandomCombo(allCombos); // **Only change after correct
            } else {
                lives--;
                System.out.println("❌ Wrong! You have " + lives + " lives left.");
                if (lives == 0) {
                    System.out.println("Game over :( Your final score is " + totalScore);
                    break;
                }
            }
        }
        scnr.close();
    }
}
