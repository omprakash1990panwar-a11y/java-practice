package interview.question;

import interview.UtilPackages.Employee;
import java.util.*;
import java.util.stream.Collectors;

public class Question072 {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000, Arrays.asList("Java", "Spring Boot"), 101, "IT"),
                new Employee("Priya", 60000, Arrays.asList("Recruitment", "Communication"), 102, "HR"),
                new Employee("Rahul", 55000, Arrays.asList("Java", "Microservices"), 103, "IT"),
                new Employee("Neha", 70000, Arrays.asList("Accounting", "Excel"), 104, "Finance"),
                new Employee("Vikas", 45000, Arrays.asList("Communication", "Payroll"), 105, "HR"),
                new Employee("Sneha", 80000, Arrays.asList("Cloud", "Docker"), 106, "IT"),
                new Employee("Karan", 65000, Arrays.asList("Accounting", "Reporting"), 107, "Finance")
        );

        // Partition the employees into those earning 60000 or more and those earning below 60000
        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                employee -> employee.getSalary() >= 60000
                        ));

        // Print the employees earning 60000 or more and those earning below 60000
        System.out.println("\n072. Employees earning 60000 or more: "
                + salaryPartition.get(true));
        System.out.println("072. Employees earning below 60000: "
                + salaryPartition.get(false));
    }
}
