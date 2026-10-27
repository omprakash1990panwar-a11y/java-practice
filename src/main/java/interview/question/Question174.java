package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question174 {
    public static void main(String[] args) {
        // =========================================================
        // Question 174: Explain forEach() versus forEachOrdered().
        // Concept: forEach() does not guarantee encounter order on a
        // parallel stream. forEachOrdered() preserves encounter order.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Q174 - Parallel forEach():");
        numbers.parallelStream()
                .forEach(number ->
                        System.out.print(number + " "));

        System.out.println();

        System.out.println("Q174 - Parallel forEachOrdered():");
        numbers.parallelStream()
                .forEachOrdered(number ->
                        System.out.print(number + " "));
    }
}