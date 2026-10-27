package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question050 {
    public static void main(String[] args) {
        // =====================================================
        // Question 050: Find the employee with the highest salary
        // reduce() compares employees and retains the higher-paid one.
        // max(Comparator.comparingDouble()) is the recommended alternative.
        // =====================================================

        List<Employee> salaryEmployees = Arrays.asList(
                new Employee("Amit", 50000),
                new Employee("Rahul", 80000),
                new Employee("Priya", 70000)
        );

        // Approach 1: Using reduce() to compare employee salaries.
        Employee highestSalary = salaryEmployees.stream()
                .reduce((a, b) ->
                        a.getSalary() > b.getSalary() ? a : b)
                .orElseThrow(() ->
                        new IllegalArgumentException("No employees"));

        System.out.println("Q50 - Highest salary using reduce(): "
                + highestSalary.getName() + " : "
                + highestSalary.getSalary());


        // Approach 2: Using max() with a salary comparator.
        Employee highest = salaryEmployees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() ->
                        new IllegalArgumentException("No employees"));

        System.out.println("Q50 - Highest salary using max(): "
                + highest.getName() + " : "
                + highest.getSalary());
    }
}
