package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question010 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 010: Check whether any number is greater than 50.
        // anyMatch() returns true if at least one element matches.
        boolean exists = numbers.stream()
                .anyMatch(n -> n > 50);

        System.out.println(
                "Q010 - Any number greater than 50: " + exists
        );
    }
}
