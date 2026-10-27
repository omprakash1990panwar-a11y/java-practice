package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question018 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 018: Find the maximum number.
        // max() returns the largest value in the stream.
        int maximum = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));

        System.out.println("Q018 - Maximum: " + maximum);
    }
}
