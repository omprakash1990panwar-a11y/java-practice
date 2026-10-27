package interview.question;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question147 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 147: Find unique characters in a string
        // Important: "Unique" here means characters appearing exactly once.
        // --------------------------------------------------

        System.out.println("Question 147:");

        String input147 = "programming";

        Map<Character, Long> frequency147 = input147.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        List<Character> uniqueCharacters = frequency147.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Unique characters: " + uniqueCharacters);
    }
}
