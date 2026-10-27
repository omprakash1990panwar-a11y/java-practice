package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question024 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(35, 10, 15, 25, 35, 45);

        // Question 024: Filter numbers greater than 14, skip three matches, and find the next.
        // skip(3) skips the first three elements that passed the filter.
        numbers.stream()
                .filter(n -> n > 14)
                .skip(3)
                .findFirst()
                .ifPresent(value -> System.out.println("Q024 - After skip: " + value));
    }
}
