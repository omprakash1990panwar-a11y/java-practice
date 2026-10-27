package interview.question;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question142 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 142: Find the first non-repeated character
        // Important: LinkedHashMap preserves character insertion order.
        // groupingBy() counts occurrences; findFirst() selects the first
        // character whose count is exactly one.
        // --------------------------------------------------

        System.out.println("Question 142:");

        String input142 = "swiss";

        Map<Character, Long> frequency142 = input142.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Character firstNonRepeated = frequency142.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("String: " + input142);
        System.out.println("First non-repeated character: "
                + firstNonRepeated);
    }
}
