package interview.question;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question143 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 143: Find the first repeated character
        // Important: Find the first character in the original string
        // whose total frequency is greater than one.
        // --------------------------------------------------

        System.out.println("Question 143:");

        String input143 = "programming";

        Map<Character, Long> frequency143 = input143.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println(frequency143);

        Character firstRepeated = input143.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> frequency143.get(ch) > 1)
                .findFirst()
                .orElse(null);

        System.out.println("String: " + input143);
        System.out.println("First repeated character: " + firstRepeated);
    }
}
