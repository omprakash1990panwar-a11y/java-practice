package interview.question;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Question181 {

    public static void main(String[] args) {

        /*
         * IMPORTANT NOTES:
         *
         * 1. Java 8 Stream API is used wherever suitable.
         * 2. Employee and Transaction are existing utility classes.
         * 3. No static inner classes or new utility classes are created.
         * 4. LinkedHashMap preserves insertion order.
         * 5. distinct() removes duplicate values from an ordered stream.
         * 6. groupingBy() groups elements by a selected property.
         * 7. Some challenges, such as the longest substring, are best solved
         *    with an algorithm using a loop and a map.
         */

        // Employee constructor:
        // Employee(String name, double salary, List<String> skills,
        //          int id, String department)

        Employee e1 = new Employee("Amit", 80000.0, null, 101, "IT");
        e1.setJobTitle("Developer");

        Employee e2 = new Employee("Priya", 60000.0, null, 102, "IT");
        e2.setJobTitle("Tester");

        Employee e3 = new Employee("Rahul", 90000.0, null, 103, "IT");
        e3.setJobTitle("Developer");

        Employee e4 = new Employee("Neha", 75000.0, null, 104, "HR");
        e4.setJobTitle("Manager");

        Employee e5 = new Employee("Karan", 50000.0, null, 105, "HR");
        e5.setJobTitle("Recruiter");

        Employee e6 = new Employee("Sneha", 70000.0, null, 106, "Finance");
        e6.setJobTitle("Analyst");

        Employee e7 = new Employee("Vikas", 65000.0, null, 107, "Finance");
        e7.setJobTitle("Accountant");

        Employee e8 = new Employee("Meera", 85000.0, null, 108, "IT");
        e8.setJobTitle("Developer");

        List<Employee> employees = Arrays.asList(
                e1, e2, e3, e4, e5, e6, e7, e8
        );


        // =========================================================
        // Question 181: Find the second-highest salary per department.
        //
        // Concept:
        // 1. Group employees by department.
        // 2. Extract salaries.
        // 3. Remove duplicate salaries.
        // 4. Sort in descending order.
        // 5. Skip the highest salary and find the next one.
        // =========================================================

        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        Map<String, Optional<Double>> secondHighestByDepartment = new LinkedHashMap<>();

        employeesByDepartment.forEach((department, departmentEmployees) -> {

            Optional<Double> secondHighest =
                    departmentEmployees.stream()
                            .map(Employee::getSalary)
                            .distinct()
                            .sorted(Comparator.reverseOrder())
                            .skip(1)
                            .findFirst();

            secondHighestByDepartment.put(department, secondHighest);
        });

        System.out.println("Q181 - Second-highest salary by department:");

        secondHighestByDepartment.forEach((department, salary) ->
                System.out.println(department + " -> " + salary)
        );

    }
}
