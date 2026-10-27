package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// --------------------------------------------------
// Question 158: Find the employees who have the same salary
// Important: Collectors.groupingBy() groups elements based on a specified key function.
// --------------------------------------------------
public class Question158 {
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

        // Find the employees who have the same salary
        // Use Collectors.groupingBy() to group employees by their salary
        Map<Double, List<Employee>> employeesBySalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));

        employeesBySalary.forEach((salary, employeesWithSalary) -> System.out.println(
                // Print the salary and the employees with that salary
                salary + " -> " + employeesWithSalary
        ));
    }
}
