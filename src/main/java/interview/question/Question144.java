package interview.question;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question144 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 144: Count occurrences of each character
        // Important: groupingBy() groups equal characters;
        // counting() counts how many times each character appears.
        // --------------------------------------------------

        System.out.println("Question 144:");

        String input144 = "programming";

        Map<Character, Long> characterCount = input144.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Character occurrences: " + characterCount);
    }
}
