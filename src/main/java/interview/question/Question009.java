package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question009 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 009: Find any element.
        // findAny() returns an Optional containing an available element.
        Optional<Integer> any = numbers.stream()
                .findAny();

        any.ifPresent(value ->
                System.out.println("Q009 - Any number: " + value));
    }
}