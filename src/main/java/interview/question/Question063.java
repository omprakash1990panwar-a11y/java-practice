
package interview.question;

import interview.UtilPackages.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Question063 {

    public static void main(String[] args) {

        // Sample employee data
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 70000,
                        LocalDate.of(1995, 5, 10)),
                new Employee(2, "Priya", "HR", 60000,
                        LocalDate.of(1993, 8, 15)),
                new Employee(3, "Rahul", "IT", 90000,
                        LocalDate.of(1990, 3, 20)),
                new Employee(4, "Neha", "Finance", 75000,
                        LocalDate.of(1997, 1, 12)),
                new Employee(5, "Vikas", "HR", 65000,
                        LocalDate.of(1992, 7, 25)),
                new Employee(6, "Sneha", "Finance", 85000,
                        LocalDate.of(1994, 11, 5)),
                new Employee(7, "Karan", "IT", 80000,
                        LocalDate.of(1991, 9, 18))
        );

        // =====================================================
        // VARIANT 1: groupingBy(classifier)
        // =====================================================
        // Group employees by department.
        // Each department becomes a key.
        // Each value contains a List of Employee objects.

        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment
                        ));

        System.out.println("1. Employees grouped by department:");

        employeesByDepartment.forEach((department, employeeList) ->System.out.println(department + " -> " + employeeList));


        // =====================================================
        // VARIANT 2: groupingBy(classifier, downstream)
        // =====================================================
        // Group employees by department.
        // Instead of keeping employee lists, calculate
        // the average salary in each department.
        //
        // Employee::getDepartment = grouping key
        // averagingDouble(...)    = calculation per group

        Map<String, Double> averageSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(
                "\n2. Average salary by department:"
        );

        averageSalaryByDepartment.forEach(
                (department, averageSalary) ->
                        System.out.println(
                                department + " -> " + averageSalary
                        )
        );


        // =====================================================
        // VARIANT 2: Another downstream example
        // =====================================================
        // Count employees in each department.
        // The result value is Long, not List<Employee>.

        Map<String, Long> employeeCountByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println(
                "\n3. Employee count by department:"
        );

        employeeCountByDepartment.forEach(
                (department, count) ->
                        System.out.println(
                                department + " -> " + count
                        )
        );


        // =====================================================
        // VARIANT 3: groupingBy(classifier, mapFactory, downstream)
        // =====================================================
        // Group by department.
        // TreeMap sorts department keys alphabetically.
        // Calculate average salary in each department.

        Map<String, Double> sortedAverageSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy
                                (
                                Employee::getDepartment,
                                TreeMap::new,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println("\n4. Average salary by department (sorted keys):");

        sortedAverageSalaryByDepartment
                .forEach((department, averageSalary) -> System.out.println( department + " -> " + averageSalary));
    }
}
