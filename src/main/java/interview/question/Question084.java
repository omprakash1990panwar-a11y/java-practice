package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question084 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering",
                        90000, "alice@example.com"),
                new Employee("Bob", "HR",
                        60000, "bob@example.com"),
                new Employee("Charlie", "Engineering",
                        75000, "charlie@example.com"),
                new Employee("Diana", "Finance",
                        50000, "diana@example.com"),
                new Employee("Ethan", null,
                        65000, null)
        );

        // =====================================================
        // Q084. filter() + findAny()
        // Find any employee in Engineering.
        //
        // IMPORTANT NOTES:
        // 1. findAny() can return any matching element.
        // 2. It does not guarantee the first matching element.
        // 3. It is useful when encounter order is not important.
        // 4. It can offer more flexibility with parallel streams.
        // 5. "Engineering".equals(...) safely handles a null department.
        // =====================================================

        Optional<Employee> anyEmployee = employees.stream()
                .filter(e -> "Engineering".equals(e.getDepartment()))
                .findAny();

        System.out.println("Q084. Any employee in Engineering: "
                + anyEmployee.orElse(null));
    }

}
