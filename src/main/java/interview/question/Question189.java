package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question189 {
    public static void main(String[] args) {

        // =========================================================
        // Question 189: Find employees whose salaries exceed
        // the overall average salary.
        //
        // Concept:
        // First calculate the overall average, then filter employees
        // whose salaries are strictly greater than that average.
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

        double overallAverageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        List<String> employeesAboveAverage = employees.stream()
                .filter(employee ->
                        employee.getSalary() > overallAverageSalary)
                .map(employee ->
                        employee.getName() + " - "
                                + employee.getSalary())
                .collect(Collectors.toList());

        System.out.println("\nQ189 - Overall average salary: "
                + overallAverageSalary);

        System.out.println("Q189 - Employees earning above average: "
                + employeesAboveAverage);

    }
}
