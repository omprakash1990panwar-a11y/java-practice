package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question089 {

    public static void main(String[] args) {

        int[] inspected = {0};

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // =====================================================
        // Q089. Short-circuiting terminal operation: anyMatch()
        //
        // IMPORTANT NOTES:
        // 1. Short-circuiting means processing can stop early.
        // 2. anyMatch() stops as soon as it finds a match.
        // 3. peek() is used here to increment the counter.
        // 4. This example demonstrates the short-circuiting behavior.
        // =====================================================

        boolean containsThree = numbers.stream()
                .peek(n -> inspected[0]++)
                .anyMatch(n -> n == 3);

        System.out.println("Q089. Contains three: " + containsThree);
    }
}
