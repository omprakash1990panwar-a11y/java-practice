package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question083 {
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
        // Q083. filter() + findFirst()
        // Find the first employee earning above 70000.
        //
        // IMPORTANT NOTES:
        // 1. filter() is an intermediate operation.
        // 2. findFirst() is a short-circuiting terminal operation.
        // 3. findFirst() respects encounter order when defined.
        // 4. It returns Optional<Employee>, not Employee directly.
        // 5. Optional helps represent a result that may be absent.
        // =====================================================

        Optional<Employee> firstEmployee = employees.stream()
                .filter(e -> e.getSalary() > 70000)
                .findFirst();

        System.out.println("Q083. First employee earning above 70000: "
                + firstEmployee.orElse(null));
    }
}
