package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question004 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 004: Count the elements in a list.
        // count() returns the number of elements in the stream.
        long count = names.stream().count();

        System.out.println("Q004 - Name count: " + count);
    }
}
