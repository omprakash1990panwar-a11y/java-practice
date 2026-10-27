package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question178 {
    public static void main(String[] args) {
        // =========================================================
        // Question 178: Explain stateless versus stateful operations.
        // Concept: filter() and map() are stateless intermediate
        // operations. sorted() and distinct() are stateful operations.
        // =========================================================

        List<Integer> unsortedNumbers = Arrays.asList(5, 2, 3, 2, 1, 5, 4);

        List<Integer> statelessResult = unsortedNumbers.stream()
                .filter(number -> number > 2)
                .map(number -> number * 10)
                .collect(Collectors.toList());

        List<Integer> statefulResult = unsortedNumbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Q178 - Stateless operations result: " + statelessResult);
        System.out.println("Q178 - Stateful operations result: " + statefulResult);
    }
}
