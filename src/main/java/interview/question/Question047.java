package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;

public class Question047 {
    public static void main(String[] args) {
        // =====================================================
        // Question 047: Calculate total employee salaries using reduce()
        // map(Employee::getSalary) extracts each employee's salary.
        // reduce() adds all salaries, starting from 0.0.
        // mapToDouble().sum() is the specialized numeric alternative.
        // =====================================================

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000),
                new Employee("Rahul", 60000),
                new Employee("Priya", 70000),
                new Employee("Neha", 40000)
        );

        // Approach 1: Using a lambda expression.
        Double totalSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("Q47 - Total salaries using lambda: "
                + totalSalaries);

        // Approach 2: Using Double.sum() as a method reference.
        Double totalSalaries2 = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Q47 - Total salaries using method reference: "
                + totalSalaries2);

        // Approach 3: Using mapToDouble() and sum().
        double totalSalary3 = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Q47 - Total salaries using mapToDouble(): "
                + totalSalary3);
    }
}
