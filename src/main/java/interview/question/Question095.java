package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question095 {

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
        // Q095. Find the Nth-highest salary.
        //
        // IMPORTANT NOTES:
        // 1. map() converts each Employee into a salary.
        // 2. distinct() ranks unique salary values.
        // 3. reverseOrder() sorts salaries from highest to lowest.
        // 4. skip(n - 1) skips the first N-1 salary values.
        // 5. findFirst() returns the Nth-highest distinct salary.
        // 6. If fewer than N distinct salaries exist, the result
        //    is an empty Optional.
        // =====================================================

        int n = 3;

        Optional<Double> nthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1L)
                .findFirst();

        System.out.println("\nQ095. " + n
                + "rd highest distinct salary: "
                + nthHighestSalary.orElse(null));
    }
}