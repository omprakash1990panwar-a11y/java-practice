package interview.question;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question149 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 149: Find the longest word in a sentence
        // Important: Split the sentence into words, then use max()
        // with a comparator based on word length.
        // --------------------------------------------------

        System.out.println("Question 149:");

        String sentence = "Java streams make coding more powerful";

        String longestWord = Arrays.stream(sentence.split("\\s+"))
                .max((word1, word2) ->
                        Integer.compare(word1.length(), word2.length()))
                .orElse("");

        System.out.println("Sentence: " + sentence);
        System.out.println("Longest word: " + longestWord);
    }
}
