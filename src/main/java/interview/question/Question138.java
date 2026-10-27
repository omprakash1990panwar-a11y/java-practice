package interview.question;

import interview.UtilPackages.Employee;

import java.util.Optional;

public class Question138 {

    // --------------------------------------------------
    // Question 138: Safely extract a nullable employee department
    // Important: ofNullable() protects against a null department.
    // --------------------------------------------------

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Employee employeeWithDepartment =
                new Employee("Amit", "IT", "Developer", 60000);

        // Use ofNullable()
        // Important: ofNullable() protects against a null value.
        String safeDepartment = Optional.ofNullable(
                        employeeWithDepartment.getDepartment()
                )
                .orElse("Unknown Department");

        System.out.println("Department: " + safeDepartment);
    }

}
