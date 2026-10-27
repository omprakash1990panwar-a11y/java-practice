package interview.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question007 {
    public static void main(String[] args) {


        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 007: Sort numbers in descending order.
        // Reverse the natural ordering with Comparator.reverseOrder().
        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Q007 - Descending: " + descending);
    }
}
