// '**' means Ai was used here, '--' is from tutorial or someone else's code, '/m' is my code when or no label is my code
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsLetterGen {
    public static List<String> loadWords(String filename) throws IOException {
        List<String> words = new ArrayList<>();

        // **Ai gen: Reads words from a file and returns them as a list
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        }
        return words;
        // **Ai gen end
    }

    // **Loop version: extracts all letter combinations of given length from the word list (ai fixed my flawed recursion attempt)
    public static Set<String> extractLetterCombinations(List<String> words, int length) {
        Set<String> combos = new HashSet<>();
        for (String word : words) {
            if (length <= word.length()) {
                extractCombosFromWord(word, length, combos);
            }
        }
        return combos;
    }

    //Extracts all substrings of a given length from a single word
    private static void extractCombosFromWord(String word, int length, Set<String> combos) {
        for (int i = 0; i <= word.length() - length; i++) {
            combos.add(word.substring(i, i + length));
        }
    }

    // **Picks a random substring from the set (if statement ai gen)
    public static String getRandomCombo(Set<String> combos) {

        if (combos == null || combos.isEmpty()) { // **ai if statement
            return ""; //throws an error if no combos available (should be humanly impossible, mainly for debugging)
        }

        List<String> list = new ArrayList<>(combos);
        Collections.shuffle(list);
        return list.get(0);
    }

    //Checks if the input word is valid and contains the target letter sequence
    public static boolean isValidWord(String input, String sequence, Set<String> validWords) {
        String lowerInput = input.toLowerCase();
        return validWords.contains(lowerInput) && lowerInput.contains(sequence);
    }
}
