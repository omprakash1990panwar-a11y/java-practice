package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Question008 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 008: Find the first element.
        // findFirst() returns an Optional containing the first element.
        Optional<Integer> first = numbers.stream()
                .findFirst();

        first.ifPresent(value ->
                System.out.println("Q008 - First number: " + value));
    }
}