package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Question130 {

    /**
     * Department-to-employee count map
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 130: Department-to-employee count map");

        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", "Developer", 60000),
                new Employee("Priya", "IT", "Tester", 50000),
                new Employee("Rahul", "IT", "Developer", 70000),
                new Employee("Neha", "HR", "Manager", 65000),
                new Employee("Karan", "HR", "Recruiter", 45000),
                new Employee("Sneha", "Finance", "Analyst", 55000)
        );

        // Group employees by their department (i.e., collect into a map)
        Map<String, Long> departmentToEmployeeCount =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println("Department-to-employee count: " + departmentToEmployeeCount);
    }
}
