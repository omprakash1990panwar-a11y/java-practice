package interview.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question043 {
    public static void main(String[] args) {
        // =====================================================
        // Question 043: Sort strings by length and alphabetically
        // comparingInt(String::length) sorts by string length.
        // reversed() sorts longer strings first.
        // thenComparing() sorts equal-length strings alphabetically.
        // max() finds the maximum string length.
        // =====================================================

        List<String> names = Arrays.asList(
                "John", "Amit", "Raj", "Priya",
                "Bob", "Ankit", "Ram"
        );

        // Sort by descending length, then alphabetical order.
        List<String> sortedNames = names.stream()
                .sorted(
                        Comparator.comparingInt(String::length)
                                .reversed()
                                .thenComparing(Comparator.naturalOrder())
                )
                .toList();

        System.out.println("Q43 - Sorted names: " + sortedNames);

        // Find the maximum length of any name.
        int maxLength = names.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(() ->
                        new IllegalArgumentException("List is empty"));

        System.out.println("Q43 - Maximum name length: " + maxLength);
    }
}
