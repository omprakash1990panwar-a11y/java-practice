package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;


public class Question088 {

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
        // Q088. anyMatch() - Check whether any employee has a null field
        //
        // IMPORTANT NOTES:
        // 1. anyMatch() returns true when one employee has a null field.
        // 2. Check each field explicitly when validating objects.
        // 3. A null-safe check is essential when calling methods on fields.
        // 4. This checks the selected fields, not every possible field.
        // =====================================================

        boolean hasNullField = employees.stream()
                .anyMatch(e ->
                        e.getName() == null
                                || e.getDepartment() == null
                                || e.getEmail() == null);

        System.out.println("Q088. Any employee has a null field: "
                + hasNullField);
    }
}
