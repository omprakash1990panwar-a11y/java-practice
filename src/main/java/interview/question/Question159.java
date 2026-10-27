package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// --------------------------------------------------
// Question 159: Find the employees who have worked in a specific department for a specific duration
// Important: Collectors.groupingBy() groups elements based on a specified key function.
// --------------------------------------------------
public class Question159 {
    public static void main(String[] args) {
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


        // --------------------------------------------------
        // Question 159: Convert employee lists into a department-to-employees map
        // Important: groupingBy() creates a list of employees for each department.
        // --------------------------------------------------

        System.out.println("\nQuestion 159:");

        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        employeesByDepartment.forEach((department, employeeList) ->
                System.out.println(
                        department + " -> " +
                                employeeList.stream()
                                        .map(Employee::getName)
                                        .collect(Collectors.toList())
                ));

    }
}
