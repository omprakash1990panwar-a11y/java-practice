package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question171 {
    public static void main(String[] args) {
        // =========================================================
        // Question 171: Compare stream() and parallelStream().
        // Concept: stream() processes sequentially by default;
        // parallelStream() enables parallel processing.
        // =========================================================

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", 80000, "amit@example.com"),
                new Employee("Priya", "IT", 60000, "priya@example.com"),
                new Employee("Rahul", "IT", 90000, "rahul@example.com"),
                new Employee("Neha", "HR", 75000, "neha@example.com"),
                new Employee("Karan", "HR", 50000, "karan@example.com")
        );

        double sequentialSalaryTotal = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double parallelSalaryTotal = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Q171 - Sequential salary total: " + sequentialSalaryTotal);
        System.out.println("Q171 - Parallel salary total: " + parallelSalaryTotal);
    }
}