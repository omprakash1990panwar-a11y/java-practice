package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question176 {
    public static void main(String[] args) {
        // =========================================================
        // Question 176: Inspect elements with peek() for debugging.
        // Concept: peek() lets you inspect elements as they pass through
        // the pipeline. It runs when a terminal operation consumes them.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> doubledNumbers = numbers.stream()
                .peek(number -> System.out.println("Q176 - Before map: " + number))
                .map(number -> number * 2)
                .peek(number -> System.out.println("Q176 - After map: " + number))
                .collect(Collectors.toList());

        System.out.println("Q176 - Final list: " + doubledNumbers);
    }
}
