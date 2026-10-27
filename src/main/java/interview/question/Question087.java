package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question087 {

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
        // Q087. allMatch() - Validate employee salary threshold
        //
        // IMPORTANT NOTES:
        // 1. allMatch() is useful for validating business rules.
        // 2. Here, every employee must earn at least 50000.
        // 3. The result is false if even one employee fails.
        // 4. An empty stream returns true (vacuous truth).
        // =====================================================

        boolean salaryValid = employees.stream()
                .allMatch(e -> e.getSalary() >= 50000);

        System.out.println("Q087. All employees earn at least 50000: "
                + salaryValid);
    }
}
