package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question020 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 020: Convert integers into strings using map().
        // String::valueOf converts each integer to its string representation.
        List<String> numberStrings = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println("Q020 - Numbers as strings: " + numberStrings);
    }
}
