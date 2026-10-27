package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question197 {

    public static void main(String[] args) {


        // =========================================================
        // Question 197: Debug an incorrect stream pipeline.
        //
        // Common mistake:
        //
        // employees.stream()
        //     .map(Employee::getSalary)
        //     .filter(employee -> employee.getSalary() > 70000)
        //
        // This does not compile because map() has already converted
        // each Employee into a double salary.
        //
        // Correct approach:
        // Filter Employee objects first, then map to names.
        // =========================================================


        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 80000.0,
                        Arrays.asList("Java", "Spring"), 101, "IT"),
                new Employee("Priya", 60000.0,
                        Arrays.asList("Java", "SQL"), 102, "IT"),
                new Employee("Rahul", 90000.0,
                        Arrays.asList("Java", "Kafka"), 103, "IT"),
                new Employee("Neha", 75000.0,
                        Arrays.asList("HR", "Communication"), 104, "HR"),
                new Employee("Karan", 50000.0,
                        Arrays.asList("Recruitment", "Communication"), 105, "HR"),
                new Employee("Sneha", 70000.0,
                        Arrays.asList("SQL", "Excel"), 106, "Finance"),
                new Employee("Vikas", 65000.0,
                        Arrays.asList("Accounting", "Excel"), 107, "Finance")
        );

        List<String> correctedPipeline = employees.stream()
                .filter(employee -> employee.getSalary() > 70000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nQ197 - Corrected pipeline result: "
                + correctedPipeline);

    }
}
