package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question013 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 013: Square every number using map().
        // Multiply each number by itself.
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Q013 - Squared numbers: " + squaredNumbers);
    }
}
