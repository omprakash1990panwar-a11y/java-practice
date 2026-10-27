package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question016 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 016: Calculate the sum using mapToInt() and sum().
        // mapToInt() converts Integer objects to primitive int values.
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Q016 - Sum: " + sum);
    }
}
