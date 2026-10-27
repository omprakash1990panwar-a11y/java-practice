package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// --------------------------------------------------
// Question 154: Find the average salary of employees in each department
// Important: averagingDouble() calculates the average of the Double values.
// --------------------------------------------------
public class Question154 {
    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", "Developer", 80000),
                new Employee("Priya", "IT", "Tester", 60000),
                new Employee("Rahul", "IT", "Developer", 90000),
                new Employee("Neha", "HR", "Manager", 75000),
                new Employee("Karan", "HR", "Recruiter", 50000),
                new Employee("Sneha", "Finance", "Analyst", 70000),
                new Employee("Vikas", "Finance", "Accountant", 65000),
                new Employee("Amit", "IT", "Developer", 80000)
        );

        // Find the average salary of employees in each department
        // Use stream API to group employees by department and find the average salary in each group
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Group by department
                        Collectors.averagingDouble(Employee::getSalary) // Find the average salary
                ));

        averageSalaryByDepartment.forEach((department, average) -> System.out.println(
                // Print the department and the average salary
                department + " -> " + average
        ));
    }
}
