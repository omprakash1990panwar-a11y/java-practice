package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question041 {
    public static void main(String[] args) {
        // =====================================================
        // Question 041: Calculate the sum of all numbers using reduce()
        // reduce(0, (a, b) -> a + b) adds all numbers, starting from 0.
        // Integer::sum performs the same addition using a method reference.
        // mapToInt().sum() is a specialized numeric stream alternative.
        // =====================================================

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Approach 1: Using a lambda expression.
        Integer sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Q41 - Sum using lambda: " + sum);

        // Approach 2: Using a method reference.
        Integer sum2 = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Q41 - Sum using method reference: " + sum2);

        // Approach 3: Using the specialized IntStream sum() method.
        Integer sum3 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q41 - Sum using mapToInt(): " + sum3);
    }
}
