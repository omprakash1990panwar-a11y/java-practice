package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question096 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 50, 20, 80, 30, 100, 40, 90, 60, 70, 100
        );

        List<String> strings = Arrays.asList(
                "Rahul", "Amit", "Priya", "Neha",
                "Karan", "Ankit", "Zoya", "Deepak"
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering",
                        90000, "alice@example.com"),
                new Employee("Bob", "HR",
                        60000, "bob@example.com"),
                new Employee("Charlie", "Engineering",
                        75000, "charlie@example.com"),
                new Employee("Diana", "Finance",
                        50000, "diana@example.com"),
                new Employee("Ethan", "HR",
                        65000, "ethan@example.com"),
                new Employee("Frank", "Engineering",
                        120000, "frank@example.com"),
                new Employee("Grace", "Finance",
                        95000, "grace@example.com"),
                new Employee("Helen", "HR",
                        85000, "helen@example.com"),
                new Employee("Ian", "Engineering",
                        110000, "ian@example.com"),
                new Employee("Julia", "Finance",
                        80000, "julia@example.com"),
                new Employee("Kevin", "HR",
                        75000, "kevin@example.com"),
                new Employee("Laura", "Engineering",
                        100000, "laura@example.com")
        );

        // =====================================================
        // Q096. Get the first five strings alphabetically.
        //
        // IMPORTANT NOTES:
        // 1. sorted() uses the natural ordering of String.
        // 2. String natural ordering is case-sensitive.
        // 3. limit(5) selects the first five sorted strings.
        // 4. collect(toList()) collects the results into a List.
        // 5. Sort before limit() to get the alphabetically first
        //    five strings from the entire input list.
        // =====================================================

        List<String> firstFiveStrings = strings.stream()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nQ096. First five strings alphabetically: "
                + firstFiveStrings);
    }
}