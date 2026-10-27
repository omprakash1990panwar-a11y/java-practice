package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question044 {

    public static void main(String[] args) {
        // =====================================================
        // Question 044: Find the minimum number using reduce()
        // reduce(Integer.MAX_VALUE, ...) keeps the smaller value.
        // min() is the direct and recommended way to find a minimum.
        // =====================================================

        List<Integer> minNumbers = Arrays.asList(10, 45, 20, 85, 5, 60);

        // Approach 1: Using reduce() and a lambda expression.
        int min = minNumbers.stream()
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);

        System.out.println("Q44 - Minimum using reduce(): " + min);

        // Approach 2: Using min() with natural integer ordering.

        int min2 = minNumbers.stream()
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new IllegalStateException("List is empty"));

        System.out.println("Q44 - Minimum using min(): " + min2);
    }
}
