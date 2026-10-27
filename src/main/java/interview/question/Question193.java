package interview.question;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Question193 {
    public static void main(String[] args) {

        // =========================================================
        // Question 193: Find the top three most frequent words.
        //
        // Concept:
        // Count words, sort map entries by frequency descending,
        // and limit the result to three entries.
        // =========================================================

        String sentences =
                "java stream java map stream java filter map stream";

        Map<String, Long> frequencies = Arrays.stream(
                        sentences.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Map<String, Long> topThreeWords = frequencies.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("\nQ193 - Top three frequent words: "
                + topThreeWords);

    }
}
