package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question100 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 50, 20, 80, 30, 100, 40, 90, 60, 70, 100
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
        // Q100. Explain why sorting before limiting matters.
        //
        // IMPORTANT NOTES:
        // 1. sorted().limit(3) sorts all input values before selecting
        //    the top three values.
        // 2. limit(3).sorted() selects only the first three input values
        //    and then sorts those three values.
        // 3. Therefore, limit(3).sorted() does not generally find
        //    the top three values from the complete input.
        // 4. The order of Stream operations can change the result.
        // 5. For very large datasets, sorting every element may be
        //    more expensive than using a dedicated top-N algorithm.
        // =====================================================

        List<Integer> correctTopThree = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        List<Integer> limitBeforeSorting = numbers.stream()
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("\nQ100. Sorting before limiting:");

        System.out.println("Correct - sorted() then limit(): "
                + correctTopThree);

        System.out.println("Different result - limit() then sorted(): "
                + limitBeforeSorting);
    }
}


