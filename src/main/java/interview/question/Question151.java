package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// --------------------------------------------------
// Question 151: Find the highest-paid employee
// Important: max() selects the employee with the highest salary.
// It returns Optional<Employee> because the list could be empty.
// --------------------------------------------------
public class Question151 {
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

        // Find the highest-paid employee
        // Use stream API to find the maximum salary and then use ifPresent to get the employee
        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary)) // Compare salaries
                .ifPresent(e -> System.out.println(
                        // Print the name and salary of the highest-paid employee
                        e.getName() + " - " + e.getSalary()
                ));
    }
}
