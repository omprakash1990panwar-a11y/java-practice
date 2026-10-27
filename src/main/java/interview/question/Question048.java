package interview.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question048 {
    public static void main(String[] args) {
        // =====================================================
        // Question 048: Find the longest string using reduce()
        // Compare string lengths and retain the longer string.
        // max() with a length comparator is an alternative approach.
        // =====================================================

        List<String> longNames = Arrays.asList(
                "Amit", "Priya", "Christopher",
                "Rahul", "Alexander"
        );

        // Approach 1: Using reduce() to retain the longest string.
        String longestString = longNames.stream()
                .reduce("", (a, b) ->
                        a.length() > b.length() ? a : b);

        System.out.println("Q48 - Longest string using reduce(): "
                + longestString);

        // Approach 2: Using max() and comparing string lengths.
        String longest = longNames.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("Q48 - Longest string using max(): "
                + longest);
    }
}
