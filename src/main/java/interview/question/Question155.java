package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// --------------------------------------------------
// Question 155: Sort employees by multiple attributes
// Important: Comparator.comparing() is used to compare the attributes.
// The Comparator.comparing() method returns a Comparator that compares objects based on their specified attribute.
// --------------------------------------------------
public class Question155 {
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

        // Sort the employees by salary in descending order
        // Use Collections.sort() to sort the list of employees
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        // Print the sorted list of employees
        employees.forEach(employee -> System.out.println(employee.getName() + " - " + employee.getSalary()));
    }
}
