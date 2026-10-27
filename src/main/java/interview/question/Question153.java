package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// --------------------------------------------------
// Question 153: Find the highest-paid employee in each department
// Important: max() selects the employee with the highest salary.
// It returns Optional<Employee> because the list could be empty.
// --------------------------------------------------
public class Question153 {
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

        // Find the highest-paid employee in each department
        // Use stream API to group employees by department and find the maximum salary in each group
        Map<String, Employee> highestPaidByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Group by department
                        Collectors.collectingAndThen( // Use collectingAndThen to find the maximum salary
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), // Find the maximum salary
                                optional -> optional.orElse(null) // Get the employee with the maximum salary
                        )
                ));

        highestPaidByDepartment.forEach((department, employee) -> System.out.println(
                // Print the department and the highest-paid employee in that department
                department + " -> " + employee.getName() + " (" + employee.getSalary() + ")"
        ));
    }
}
