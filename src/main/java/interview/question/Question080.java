package interview.question;

import interview.UtilPackages.Employee;
import java.util.*;
import java.util.stream.Collectors;

public class Question080 {
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

        // Map the employees to their names and create an unmodifiable list
        List<String> unmodifiableNames =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        ));

        // Print the unmodifiable employee names
        System.out.println("\n080. Unmodifiable employee names: "
                + unmodifiableNames);


        // Group the employees by department and count the number of employees in each department
        Map<String, Long> departmentCount =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.counting()));

        // Print the department count
        System.out.println("\n081. Department count: "
                + departmentCount);


        // Sort the employees by salary in descending order
        List<Employee> sortedEmployees =
                employees.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .collect(Collectors.toList());

        // Print the sorted employees
        System.out.println("\n082. Sorted employees: "
                + sortedEmployees);


    }
}