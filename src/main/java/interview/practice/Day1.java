
package interview.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Day1 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 001: Print all elements using forEach().
        // forEach() performs an action for every stream element.
        names.stream().forEach(System.out::print);

        // Question 002: Filter even numbers.
        // filter() retains only numbers divisible by 2.
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Q002 - Even numbers: " + evenNumbers);

        // Question 003: Convert all names to uppercase using map().
        // map() transforms each string into its uppercase equivalent.
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Q003 - Uppercase names: " + upperCaseNames);

        // Question 004: Count the elements in a list.
        // count() returns the number of elements in the stream.
        long count = names.stream().count();

        System.out.println("Q004 - Name count: " + count);

        // Question 005: Remove duplicate numbers using distinct().
        // distinct() retains one occurrence of each value.
        List<Integer> withoutDuplicates = numbers.stream()
                .distinct()
                .toList();

        System.out.println("Q005 - Distinct numbers: " + withoutDuplicates);

        // Question 006: Sort numbers in ascending order.
        // sorted() uses natural integer ordering by default.
        List<Integer> ascending = numbers.stream()
                .sorted()
                .toList();

        System.out.println("Q006 - Ascending: " + ascending);

        // Question 007: Sort numbers in descending order.
        // Reverse the natural ordering with Comparator.reverseOrder().
        List<Integer> descending = numbers.stream()
                .sorted(java.util.Comparator.reverseOrder())
                .toList();

        System.out.println("Q007 - Descending: " + descending);

        // Question 008: Find the first element.
        // findFirst() returns an Optional containing the first match.
        Optional<Integer> first = numbers.stream().findFirst();

        first.ifPresent(value ->
                System.out.println("Q008 - First number: " + value));

        // Question 009: Find any element.
        // findAny() may return any element, especially in parallel streams.
        Optional<Integer> any = numbers.stream().findAny();

        any.ifPresent(value ->
                System.out.println("Q009 - Any number: " + value));

        // Question 010: Check whether any number is greater than 50.
        // anyMatch() returns true if at least one element satisfies the condition.
        boolean exists = numbers.stream().anyMatch(n -> n > 50);

        System.out.println("Q010 - Any number greater than 50: " + exists);
    }
}
