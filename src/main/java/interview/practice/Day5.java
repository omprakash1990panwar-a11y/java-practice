package interview.practice;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {

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


        // =====================================================
        // Question 042: Multiply all numbers using reduce()
        // reduce(1, (a, b) -> a * b) multiplies every number.
        // The identity value is 1 because multiplying by 1 changes nothing.
        // =====================================================

        List<Integer> multiplicationNumbers = Arrays.asList(2, 3, 4, 5);

        Integer multiple = multiplicationNumbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Q42 - Product of all numbers: " + multiple);


        // =====================================================
        // Question 043: Sort strings by length and alphabetically
        // comparingInt(String::length) sorts by string length.
        // reversed() sorts longer strings first.
        // thenComparing() sorts equal-length strings alphabetically.
        // max() finds the maximum string length.
        // =====================================================

        List<String> names = Arrays.asList(
                "John", "Amit", "Raj", "Priya",
                "Bob", "Ankit", "Ram"
        );

        // Sort by descending length, then alphabetical order.
        List<String> sortedNames = names.stream()
                .sorted(
                        Comparator.comparingInt(String::length)
                                .reversed()
                                .thenComparing(Comparator.naturalOrder())
                )
                .toList();

        System.out.println("Q43 - Sorted names: " + sortedNames);

        // Find the maximum length of any name.
        int maxLength = names.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(() ->
                        new IllegalArgumentException("List is empty"));

        System.out.println("Q43 - Maximum name length: " + maxLength);


        // =====================================================
        // Question 044: Find the minimum number using reduce()
        // reduce(Integer.MAX_VALUE, ...) keeps the smaller value.
        // min() is the direct and recommended way to find a minimum.
        // =====================================================

        List<Integer> minNumbers = Arrays.asList(10, 45, 20, 85, 5, 60);

        // Approach 1: Using reduce() and a lambda expression.
        int min = minNumbers.stream()
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);

        System.out.println("Q44 - Minimum using reduce(): " + min);

        // Approach 2: Using min() with natural integer ordering.
        int min2 = minNumbers.stream()
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new IllegalStateException("List is empty"));

        System.out.println("Q44 - Minimum using min(): " + min2);


        // =====================================================
        // Question 045: Concatenate strings using reduce()
        // reduce("", (a, b) -> a + b) combines strings without separators.
        // Collectors.joining(" ") joins strings with a space between them.
        // =====================================================

        List<String> words = Arrays.asList("Java", "Spring", "Boot");

        // Approach 1: Using parallelStream() and reduce().
        String concatenated = words.parallelStream()
                .reduce("", (a, b) -> a + b);

        System.out.println("Q45 - Concatenation using reduce(): "
                + concatenated);

        // Approach 2: Using Collectors.joining().
        String concatenated2 = words.stream()
                .collect(Collectors.joining(" "));

        System.out.println("Q45 - Concatenation using joining(): "
                + concatenated2);


        // =====================================================
        // Question 046: Calculate factorial using reduce()
        // IntStream.rangeClosed(1, number) generates 1 through number.
        // reduce(1, (a, b) -> a * b) multiplies the generated numbers.
        // Factorial of 5 = 1 * 2 * 3 * 4 * 5 = 120.
        // =====================================================

        int number = 5;

        int factorial = IntStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);

        System.out.println("Q46 - Factorial of " + number + ": "
                + factorial);


        // =====================================================
        // Question 047: Calculate total employee salaries using reduce()
        // map(Employee::getSalary) extracts each employee's salary.
        // reduce() adds all salaries, starting from 0.0.
        // mapToDouble().sum() is the specialized numeric alternative.
        // =====================================================

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000),
                new Employee("Rahul", 60000),
                new Employee("Priya", 70000),
                new Employee("Neha", 40000)
        );

        // Approach 1: Using a lambda expression.
        Double totalSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("Q47 - Total salaries using lambda: "
                + totalSalaries);

        // Approach 2: Using Double.sum() as a method reference.
        Double totalSalaries2 = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Q47 - Total salaries using method reference: "
                + totalSalaries2);

        // Approach 3: Using mapToDouble() and sum().
        double totalSalary3 = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Q47 - Total salaries using mapToDouble(): "
                + totalSalary3);


        // =====================================================
        // Question 048: Find the longest string using reduce()
        // Compare string lengths and retain the longer string.
        // max() with a length comparator is an alternative approach.
        // =====================================================

        List<String> longNames = Arrays.asList(
                "Amit", "Priya", "Christopher",
                "Rahul", "Alexander"
        );

        // Approach 1: Using reduce() to retain the longest string.
        String longestString = longNames.stream()
                .reduce("", (a, b) ->
                        a.length() > b.length() ? a : b);

        System.out.println("Q48 - Longest string using reduce(): "
                + longestString);

        // Approach 2: Using max() and comparing string lengths.
        String longest = longNames.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("Q48 - Longest string using max(): "
                + longest);


        // =====================================================
        // Question 049: Find the shortest string using reduce()
        // reduce() retains the shorter string in each comparison.
        // mapToInt().min() finds the minimum length.
        // filter() returns every string having that minimum length.
        // =====================================================

        List<String> shortNames = Arrays.asList(
                "Amit", "Priya", "Raj",
                "Christopher", "Ram", "John"
        );

        // Approach 1: Find one shortest string using reduce().
        String shortestString = shortNames.stream()
                .reduce((a, b) ->
                        a.length() <= b.length() ? a : b)
                .orElse("");

        System.out.println("Q49 - Shortest string using reduce(): "
                + shortestString);

        // Approach 2: Find the minimum string length.
        int minLength = shortNames.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        System.out.println("Q49 - Minimum string length: " + minLength);

        // Return all strings whose length equals the minimum length.
        List<String> shortestStringsList = shortNames.stream()
                .filter(name -> name.length() == minLength)
                .collect(Collectors.toList());

        System.out.println("Q49 - All shortest strings: "
                + shortestStringsList);


        // =====================================================
        // Question 050: Find the employee with the highest salary
        // reduce() compares employees and retains the higher-paid one.
        // max(Comparator.comparingDouble()) is the recommended alternative.
        // =====================================================

        List<Employee> salaryEmployees = Arrays.asList(
                new Employee("Amit", 50000),
                new Employee("Rahul", 80000),
                new Employee("Priya", 70000)
        );

        // Approach 1: Using reduce() to compare employee salaries.
        Employee highestSalary = salaryEmployees.stream()
                .reduce((a, b) ->
                        a.getSalary() > b.getSalary() ? a : b)
                .orElseThrow(() ->
                        new IllegalArgumentException("No employees"));

        System.out.println("Q50 - Highest salary using reduce(): "
                + highestSalary.getName() + " : "
                + highestSalary.getSalary());

        // Approach 2: Using max() with a salary comparator.
        Employee highest = salaryEmployees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() ->
                        new IllegalArgumentException("No employees"));

        System.out.println("Q50 - Highest salary using max(): "
                + highest.getName() + " : "
                + highest.getSalary());
    }
}