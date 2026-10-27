package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question091 {

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
        // Q091. Find the top three highest numbers.
        //
        // IMPORTANT NOTES:
        // 1. sorted() sorts the elements in ascending order by default.
        // 2. Comparator.reverseOrder() sorts numbers in descending order.
        // 3. limit(3) returns at most the first three sorted elements.
        // 4. Duplicate numbers are retained unless distinct() is used.
        // 5. This question asks for the top three elements, not distinct
        //    values, so duplicate numbers are allowed.
        // =====================================================

        List<Integer> topThreeNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Q091. Top three highest numbers: "
                + topThreeNumbers);
    }
}