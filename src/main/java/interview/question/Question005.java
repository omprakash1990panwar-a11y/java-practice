package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question005 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );


        // Question 005: Remove duplicate numbers using distinct().
        // distinct() retains one occurrence of each value.
        List<Integer> withoutDuplicates = numbers.stream()
                .distinct()
                .toList();

        System.out.println("Q005 - Distinct numbers: " + withoutDuplicates);
    }
}
