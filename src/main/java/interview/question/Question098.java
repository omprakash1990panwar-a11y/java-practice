package interview.question;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Question098 {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering",
                        90000, "alice@example.com"),
                new Employee("Bob", "HR",
                        60000, "bob@example.com"),
                new Employee("Charlie", "Engineering",
                        75000, "charlie@example.com"),
                new Employee("Diana", "Finance",
                        50000, "diana@example.com"),
                new Employee("Ethan", "HR",
                        65000, "ethan@example.com"),
                new Employee("Frank", "Engineering",
                        120000, "frank@example.com"),
                new Employee("Grace", "Finance",
                        95000, "grace@example.com"),
                new Employee("Helen", "HR",
                        85000, "helen@example.com"),
                new Employee("Ian", "Engineering",
                        110000, "ian@example.com"),
                new Employee("Julia", "Finance",
                        80000, "julia@example.com"),
                new Employee("Kevin", "HR",
                        75000, "kevin@example.com"),
                new Employee("Laura", "Engineering",
                        100000, "laura@example.com")
        );

        // =====================================================
        // Q098. Find the highest-paid three employees per department.
        //
        // IMPORTANT NOTES:
        // 1. groupingBy() groups employees by department.
        // 2. Each department gets its own employee list.
        // 3. collectingAndThen() transforms the collected list.
        // 4. Inside each group, sort salaries in descending order.
        // 5. limit(3) selects up to three employees per department.
        // 6. TreeMap keeps department names in sorted order.
        // 7. This example assumes department names are not null.
        // =====================================================

Map<String, List<Employee>> topThreePerDepartment =
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,        // Argument 1
                        TreeMap::new,                    // Argument 2
                        Collectors.collectingAndThen(    // Argument 3
                                Collectors.toList(),
                                departmentEmployees ->
                                        departmentEmployees.stream()
                                                .sorted(
                                                        Comparator
                                                                .comparingDouble(
                                                                        Employee::getSalary)
                                                                .reversed()
                                                )
                                                .limit(3)
                                                .collect(Collectors.toList())
                        )
                ));

        System.out.println("\nQ098. Top three highest-paid employees "
                + "per department:");

        topThreePerDepartment.forEach((department, employeeList) ->
                System.out.println(department + " -> " + employeeList));
    }
}