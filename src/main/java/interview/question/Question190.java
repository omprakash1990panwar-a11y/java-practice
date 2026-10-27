package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question190 {
    public static void main(String[] args) {



        // =========================================================
        // Question 190: Build a nested department-to-job-title
        // employee count map.
        //
        // Concept:
        // Outer groupingBy() groups employees by department.
        // Inner groupingBy() groups each department by job title.
        // counting() counts employees in each group.
        // =========================================================


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
        // Question 190: Build a nested department-to-job-title
        // employee count map.
        //
        // Concept:
        // Outer groupingBy() groups employees by department.
        // Inner groupingBy() groups each department by job title.
        // counting() counts employees in each group.
        // =========================================================

        Map<String, Map<String, Long>> departmentJobTitleCounts =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.groupingBy(
                                        Employee::getJobTitle,
                                        LinkedHashMap::new,
                                        Collectors.counting()
                                )
                        ));

        System.out.println("\nQ190 - Department to job-title employee counts:");

        departmentJobTitleCounts.forEach((department, jobTitleCounts) ->
                System.out.println(department + " -> " + jobTitleCounts)
        );
    }
}
