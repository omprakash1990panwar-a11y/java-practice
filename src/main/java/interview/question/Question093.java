package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question093 {

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
        // Q093. Implement pagination using skip() and limit().
        //
        // IMPORTANT NOTES:
        // 1. Pagination divides records into smaller pages.
        // 2. Page numbers start from 1 in this example.
        // 3. skip((pageNumber - 1) * pageSize) skips previous pages.
        // 4. limit(pageSize) restricts the number of records per page.
        // 5. Page 1 skips 0 records; page 2 skips 3 records when
        //    the page size is 3.
        // 6. Pagination here follows the original list order.
        // =====================================================

        int pageNumber = 2;
        int pageSize = 3;

        List<Employee> employeePage = employees.stream()
                .skip((pageNumber - 1L) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        System.out.println("\nQ093. Employees on page " + pageNumber
                + ": " + employeePage);
    }
}