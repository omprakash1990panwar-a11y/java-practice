package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Question127 {

    /**
     * Find the least frequent element in a list
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 127: Find the least frequent element");

        // List of integers
        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 10, 40, 30
        );

        // Group numbers by their value (i.e., collect into a map)
        Map<Integer, Long> numberFrequency = numbers.stream()
                .collect(Collectors.groupingBy(
                        number -> number,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        // Find the minimum value in the map
        Map.Entry<Integer, Long> leastFrequent = numberFrequency.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        if (leastFrequent != null) {
            System.out.println("Least frequent element: " + leastFrequent.getKey());
            System.out.println("Frequency: " + leastFrequent.getValue());
        }
    }
}
