package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question185 {

    public static void main(String[] args) {


        // =========================================================
        // Question 185: Find pairs of numbers whose sum equals a target.
        //
        // Concept:
        // Use flatMap() to examine combinations.
        // Only consider a < b to avoid reversed duplicate pairs.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;

        List<List<Integer>> pairs = numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a < b && a + b == target)
                        .map(b -> Arrays.asList(a, b)
                        )
                )
                .collect(Collectors.toList());

        System.out.println("\nQ185 - Pairs with sum " + target
                + ": " + pairs);


    }
}
