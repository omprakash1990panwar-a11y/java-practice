package interview.question;

import java.util.stream.IntStream;

public class Question046 {
    public static void main(String[] args) {
        // =====================================================
        // Question 046: Calculate factorial using reduce()
        // IntStream.rangeClosed(1, number) generates 1 through number.
        // reduce(1, (a, b) -> a * b) multiplies the generated numbers.
        // Factorial of 5 = 1 * 2 * 3 * 4 * 5 = 120.
        // =====================================================

        int number = 5;

        int factorial = IntStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);

        System.out.println("Q46 - Factorial of " + number + ": "
                + factorial);
    }
}
