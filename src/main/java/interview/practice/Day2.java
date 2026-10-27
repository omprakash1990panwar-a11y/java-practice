
package interview.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                200, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        // Question 011: Extract even numbers using filter().
        // Retain numbers whose remainder after division by 2 is zero.
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Q011 - Even numbers: " + evenNumbers);

        // Question 012: Extract odd numbers using filter().
        // Retain numbers whose remainder after division by 2 is not zero.
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        System.out.println("Q012 - Odd numbers: " + oddNumbers);

        // Question 013: Square every number using map().
        // Multiply each number by itself.
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();

        System.out.println("Q013 - Squared numbers: " + squaredNumbers);

        // Question 014: Convert strings into their lengths using map().
        // String::length returns the character count of each name.
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .toList();

        System.out.println("Q014 - Name lengths: " + nameLengths);

        // Question 015: Convert numeric strings into integers.
        // Integer.parseInt() converts each numeric string into an Integer.
        List<String> numericStrings = Arrays.asList(
                "100", "200", "300", "400"
        );

        List<Integer> converted = numericStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Q015 - Parsed integers: " + converted);

        // Alternative: use a lambda expression instead of a method reference.
        List<Integer> converted2 = numericStrings.stream()
                .map(value -> Integer.parseInt(value))
                .toList();

        System.out.println("Q015 - Parsed using lambda: " + converted2);

        // Question 016: Calculate the sum using mapToInt() and sum().
        // mapToInt() converts Integer objects into primitive int values.
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q016 - Sum: " + sum);

        // Question 017: Calculate the average using average().
        // average() returns an OptionalDouble because the stream may be empty.
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Q017 - Average: " + average);

        // Question 018: Find the maximum number.
        // max() returns the largest element according to the comparator.
        int maximum = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() ->
                        new IllegalArgumentException("List is empty"));

        System.out.println("Q018 - Maximum: " + maximum);

        // Question 019: Find the minimum number.
        // min() returns the smallest element.
        int minimum = numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() ->
                        new IllegalArgumentException("List is empty"));

        System.out.println("Q019 - Minimum: " + minimum);

        // Question 020: Convert integers into strings using map().
        // String::valueOf converts each integer into its string representation.
        List<String> numberStrings = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println("Q020 - Numbers as strings: " + numberStrings);

        // Additional examples preserved from your Question3 class.

        // Convert numeric strings to doubles and calculate their sum.
        double doubleSum = numericStrings.stream()
                .mapToDouble(Double::parseDouble)
                .sum();

        System.out.println("Additional - Numeric string sum: " + doubleSum);

        // Calculate a total using mapToLong() and method reference.
        long total = converted.stream()
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println("Additional - Total using method reference: " + total);

        // Alternative: use a lambda to convert Integer to long.
        long total2 = converted.stream()
                .mapToLong(value -> Long.valueOf(value))
                .sum();

        System.out.println("Additional - Total using lambda: " + total2);

        // Filter numbers greater than 14, skip the first three matches,
        // and print the next matching number, if present.
        List<Integer> skipNumbers = Arrays.asList(35, 10, 15, 25, 35, 45);

        skipNumbers.stream()
                .filter(n -> n > 14)
                .skip(3)
                .findFirst()
                .ifPresent(value ->
                        System.out.println("Additional - After skip: " + value));

        // Convert each name into a map entry:
        // key = name, value = number of characters in the name.
        java.util.Map<String, Integer> nameCharacterCounts = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println("Additional - Name character counts: "
                + nameCharacterCounts);

        // Alternative: use Function.identity() to retain the original name as key.
        java.util.Map<String, Integer> nameCharacterCounts2 = names.stream()
                .collect(Collectors.toMap(
                        java.util.function.Function.identity(),
                        String::length
                ));

        System.out.println("Additional - Name counts using identity(): "
                + nameCharacterCounts2);
    }
}
