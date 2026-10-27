package interview.question;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Question200 {
    public static void main(String[] args) {


        // =========================================================
        // Question 200: Solve an employee analytics problem and
        // explain time and space complexity.
        //
        // Problem:
        // 1. Calculate the overall average salary.
        // 2. Find employees earning above that average.
        // 3. Find the highest-paid employee in each department.
        //
        // Complexity:
        // Average calculation: O(E)
        // Filtering employees: O(E)
        // Grouping and finding department maxima: O(E)
        // Overall time: O(E), assuming hash-based grouping.
        // Auxiliary space: O(E) for the grouped results and output.
        // E = number of employees.
        // =========================================================

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 80000.0,
                        Arrays.asList("Java", "Spring"), 101, "IT"),
                new Employee("Priya", 60000.0,
                        Arrays.asList("Java", "SQL"), 102, "IT"),
                new Employee("Rahul", 90000.0,
                        Arrays.asList("Java", "Kafka"), 103, "IT"),
                new Employee("Neha", 75000.0,
                        Arrays.asList("HR", "Communication"), 104, "HR"),
                new Employee("Karan", 50000.0,
                        Arrays.asList("Recruitment", "Communication"), 105, "HR"),
                new Employee("Sneha", 70000.0,
                        Arrays.asList("SQL", "Excel"), 106, "Finance"),
                new Employee("Vikas", 65000.0,
                        Arrays.asList("Accounting", "Excel"), 107, "Finance")
        );

        double overallAverage = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        List<String> aboveAverageEmployees = employees.stream()
                .filter(employee ->
                        employee.getSalary() > overallAverage)
                .map(employee ->
                        employee.getName() + " (" + employee.getSalary() + ")")
                .collect(Collectors.toList());

        Map<String, Optional<Employee>> highestPaidByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(
                                                Employee::getSalary
                                        )
                                )
                        ));

        Map<String, String> highestPaidNames = new LinkedHashMap<>();

        highestPaidByDepartment.forEach((department, employeeOptional) ->
                employeeOptional.ifPresent(employee ->
                        highestPaidNames.put(
                                department,
                                employee.getName() + " ("
                                        + employee.getSalary() + ")"
                        )
                )
        );

        System.out.println("\nQ200 - Overall average salary: "
                + overallAverage);

        System.out.println("Q200 - Employees earning above average: "
                + aboveAverageEmployees);

        System.out.println("Q200 - Highest-paid employee by department: "
                + highestPaidNames);
    }
}
