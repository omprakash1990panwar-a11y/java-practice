package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question177 {
    public static void main(String[] args) {
        // =========================================================
        // Question 177: Explain lazy intermediate operations.
        // Concept: filter() and map() do not run until a terminal
        // operation is invoked. limit() can short-circuit processing.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> lazyResult = numbers.stream()
                .filter(number -> {
                    System.out.println("Q177 - Filtering: " + number);
                    return number > 2;
                })
                .map(number -> {
                    System.out.println("Q177 - Mapping: " + number);
                    return number * 10;
                })
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Q177 - Result: " + lazyResult);
    }
}
