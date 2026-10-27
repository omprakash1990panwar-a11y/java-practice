package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question001 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Amit", "Rahul", "Priya", "Neha", "Vikas","Sneha", "Arjun", "Pooja", "Rohit", "Anjali");

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 001: Print all elements using forEach().
        // forEach() performs an action for every stream element.

        names.stream().forEach(System.out::println);

        numbers.forEach(System.out::println);
    }
}
