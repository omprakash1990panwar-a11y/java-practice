package interview.question;

import interview.UtilPackages.Employee;

import java.util.Optional;

public class Question136 {

    // --------------------------------------------------
    // Question 136: Chain Optional values using flatMap()
    // Important: flatMap() avoids Optional<Optional<T>> nesting.
    // Use it when the mapping function itself returns an Optional.
    // --------------------------------------------------

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Optional<Employee> optionalEmployee =
                Optional.of(new Employee("Amit", "IT", "Developer", 60000));

        // Use flatMap()
        // Important: flatMap() unwraps the value inside the Optional and applies a function to it.
        Optional<String> department =
                optionalEmployee.flatMap(
                        emp -> Optional.ofNullable(emp.getDepartment())
                );

        System.out.println("Department: " +
                department.orElse("Department not available"));
    }

}
