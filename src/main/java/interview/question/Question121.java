package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question121 {

    /**
     * Find duplicate strings in a list of words
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 121: Find duplicate strings");

        // List of words
        List<String> words = Arrays.asList(
                "Java", "Spring", "Java", "Docker",
                "Spring", "Java", "Microservices"
        );

        // Group words by their value (i.e., collect into a map)
        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println(wordFrequency);
        // Filter the map for words that appear more than once
        Map<String, Long> duplicateWords = wordFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Duplicate strings: " + duplicateWords);
    }
}
