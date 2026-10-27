package interview.question;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question192 {
    public static void main(String[] args) {

        // =========================================================
        // Question 192: Implement frequency counting without external libraries.
        //
        // Concept:
        // Split text into words, normalize case, and use groupingBy()
        // with counting() to calculate each word's frequency.
        // =========================================================

        String text = "Java Stream Java Map Stream Java";

        Map<String, Long> wordFrequency = Arrays.stream(
                        text.toLowerCase().split("\\s+"))
                .collect(
                        Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()
                        ));

        System.out.println("\nQ192 - Word frequencies: " + wordFrequency);
    }
}
