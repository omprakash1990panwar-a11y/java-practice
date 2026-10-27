package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question006 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );


        // Question 006: Sort numbers in ascending order.
        // sorted() uses natural integer ordering by default.
        List<Integer> ascending = numbers.stream()
                .sorted()
                .toList();

        System.out.println("Q006 - Ascending: " + ascending);

    }
}
