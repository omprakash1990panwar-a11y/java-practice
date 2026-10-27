package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question162 {

    public static void main(String[] args) {

        // =========================================================
        // Question 162: Remove duplicates while preserving encounter order.
        // Concept: distinct() preserves the encounter order of an ordered stream.
        // =========================================================

        List<String> names = Arrays.asList(
                "Amit", "Priya", "Amit", "Rahul", "Priya", "Neha"
        );

        List<String> uniqueNames = names.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Q162 - Unique names: " + uniqueNames);

    }
}
