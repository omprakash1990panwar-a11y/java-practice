package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question124 {

    /**
     * Frequency map of characters in a string
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 124: Frequency map of characters");

        // String to process
        String text = "programming";

        // Group characters by their value (i.e., collect into a map)
        Map<Character, Long> characterFrequency = text.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Character frequency: " + characterFrequency);
    }
}
