package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question049 {
    public static void main(String[] args) {
        // =====================================================
        // Question 049: Find the shortest string using reduce()
        // reduce() retains the shorter string in each comparison.
        // mapToInt().min() finds the minimum length.
        // filter() returns every string having that minimum length.
        // =====================================================

        List<String> shortNames = Arrays.asList(
                "Amit", "Priya", "Raj",
                "Christopher", "Ram", "John"
        );

        // Approach 1: Find one shortest string using reduce().
        String shortestString = shortNames.stream()
                .reduce((a, b) ->
                        a.length() <= b.length() ? a : b)
                .orElse("");

        System.out.println("Q49 - Shortest string using reduce(): "
                + shortestString);

        // Approach 2: Find the minimum string length.
        int minLength = shortNames.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        System.out.println("Q49 - Minimum string length: " + minLength);

        // Return all strings whose length equals the minimum length.
        List<String> shortestStringsList = shortNames.stream()
                .filter(name -> name.length() == minLength)
                .collect(Collectors.toList());

        System.out.println("Q49 - All shortest strings: "
                + shortestStringsList);
    }
}
