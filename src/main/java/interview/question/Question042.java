package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question042 {
    public static void main(String[] args) {
        // =====================================================
        // Question 042: Multiply all numbers using reduce()
        // reduce(1, (a, b) -> a * b) multiplies every number.
        // The identity value is 1 because multiplying by 1 changes nothing.
        // =====================================================

        List<Integer> multiplicationNumbers = Arrays.asList(2, 3, 4, 5);

        Integer multiple = multiplicationNumbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Q42 - Product of all numbers: " + multiple);
    }
}
