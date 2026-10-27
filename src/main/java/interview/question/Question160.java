package interview.question;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Question160 {

    // --------------------------------------------------
    // Question 160: Calculate payroll totals and statistics by department
    // Important: summarizingInt() calculates count, sum, min, max and average.
    // --------------------------------------------------



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



        System.out.println("\nQuestion 160:");

        Map<String, DoubleSummaryStatistics> payrollStatistics =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.summarizingDouble(Employee::getSalary)
                        ));

        payrollStatistics.forEach((department, stats) ->
                System.out.println(
                        department
                                + " -> Total: " + stats.getSum()
                                + ", Count: " + stats.getCount()
                                + ", Min: " + stats.getMin()
                                + ", Max: " + stats.getMax()
                                + ", Average: " + stats.getAverage()
                ));
    }
    }

