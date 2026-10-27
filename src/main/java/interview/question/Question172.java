package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question172 {
    public static void main(String[] args) {
        // =========================================================
        // Question 172: Convert a stream to parallel using parallel().
        // Concept: parallel() switches the stream pipeline to parallel mode.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int parallelSum = numbers.stream()
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q172 - Sum using parallel(): " + parallelSum);
    }
}
