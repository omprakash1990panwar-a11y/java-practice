package interview.question;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question123 {

    /**
     * Frequency map of integers in a list
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 123: Frequency map of integers");

        // List of integers
        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 10, 40, 30
        );

        // Group numbers by their value (i.e., collect into a map)
        Map<Integer, Long> numberFrequency = numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Integer frequency: " + numberFrequency);


        // Find the number with the lowest frequency.
        numberFrequency.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println(
                                "Least repeated number: " + entry.getKey()
                                        + ", Frequency: " + entry.getValue()
                        )
                );
    }
}
