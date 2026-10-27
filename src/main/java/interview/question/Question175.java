package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question175 {
    public static void main(String[] args) {
        // =========================================================
        // Question 175: Explain encounter order and unordered().
        // Concept: encounter order is the order defined by the source.
        // unordered() removes the requirement to preserve that order.
        // It does not necessarily shuffle the elements.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Q175 - Original encounter order:");
        numbers.stream()
                .forEach(number ->
                        System.out.print(number + " "));

        System.out.println();

        System.out.println("Q175 - Parallel unordered() traversal:");
        numbers.parallelStream()
                .unordered()
                .forEach(number ->
                        System.out.print(number + " "));
    }
}
