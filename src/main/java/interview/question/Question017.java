package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question017 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 017: Calculate the average.
        // average() returns OptionalDouble; orElse() handles an empty stream.
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Q017 - Average: " + average);
    }
}
