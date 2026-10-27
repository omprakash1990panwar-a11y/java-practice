package interview.question;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question146 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 146: Find duplicate characters in a string
        // Important: Keep only characters with frequency greater than one.
        // LinkedHashMap maintains their first-appearance order.
        // --------------------------------------------------

        System.out.println("Question 146:");

        String input146 = "programming";

        Map<Character, Long> frequency146 = input146.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        List<Character> duplicateCharacters = frequency146.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate characters: "
                + duplicateCharacters);
    }
}
