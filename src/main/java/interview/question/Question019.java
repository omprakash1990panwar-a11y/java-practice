package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question019 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 019: Find the minimum number.
        // min() returns the smallest value in the stream.
        int minimum = numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));

        System.out.println("Q019 - Minimum: " + minimum);
    }
}
