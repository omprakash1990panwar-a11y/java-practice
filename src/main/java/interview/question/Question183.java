package interview.question;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question183 {

    public static void main(String[] args) {

        // =========================================================
        // Question 183: Find the most common word in a list of sentences. or must occurred word
        //
        // Concept:
        // flatMap() converts sentences into individual words.
        // Normalize case, remove punctuation, count words, and find the max.
        // =========================================================

        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "Java streams simplify collections",
                "Java is powerful and Java is popular"
        );

        Map<String, Long> wordFrequency = sentences.stream()
                .flatMap(sentence -> Arrays.stream(
                        sentence.toLowerCase()
                                .replaceAll("[^a-z0-9\\s]", "")
                                .split("\\s+")
                ))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Optional<Map.Entry<String, Long>> mostCommonWord =
                wordFrequency.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue());

        mostCommonWord.ifPresent(entry ->
                System.out.println("\nQ183 - Most common word: "
                        + entry.getKey() + " ("
                        + entry.getValue() + " occurrences)")
        );
    }
}
