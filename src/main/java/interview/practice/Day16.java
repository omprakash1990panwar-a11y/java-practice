package interview.practice;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day16 {

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

        // Additional data for questions that require age or employee ID.
        // These records are aligned with the employees list by index.
        List<Integer> ages = Arrays.asList(30, 27, 32, 35, 25, 29, 31, 30);
        List<Integer> employeeIds =
                Arrays.asList(101, 102, 103, 104, 105, 106, 107, 101);


        // --------------------------------------------------
        // Question 151: Find the highest-paid employee
        // Important: max() selects the employee with the highest salary.
        // It returns Optional<Employee> because the list could be empty.
        // --------------------------------------------------

        System.out.println("Question 151:");

        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(e -> System.out.println(
                        e.getName() + " - " + e.getSalary()
                ));


        // --------------------------------------------------
        // Question 152: Find the second-highest-paid employee
        // Important: Distinct salary levels first, then sort descending.
        // This finds an employee earning the second-highest DISTINCT salary.
        // --------------------------------------------------

        System.out.println("\nQuestion 152:");

        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(salary -> System.out.println(
                        "Second-highest distinct salary: " + salary
                ));


        // --------------------------------------------------
        // Question 153: Find the highest-paid employee in each department
        // Important: groupingBy() separates departments.
        // maxBy() selects the highest-paid employee within each group.
        // --------------------------------------------------

        System.out.println("\nQuestion 153:");

        Map<String, Employee> highestPaidByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingDouble(
                                                        Employee::getSalary
                                                )
                                        ),
                                        optional -> optional.orElse(null)
                                )
                        ));

        highestPaidByDepartment.forEach((department, employee) ->
                System.out.println(
                        department + " -> " + employee.getName()
                                + " (" + employee.getSalary() + ")"
                ));


        // --------------------------------------------------
        // Question 154: Calculate average salary by department
        // Important: averagingInt() calculates each group's mean salary.
        // --------------------------------------------------

        System.out.println("\nQuestion 154:");

        Map<String, Double> averageSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        averageSalaryByDepartment.forEach((department, average) ->
                System.out.println(department + " -> " + average));


        // --------------------------------------------------
        // Question 155: Find employees earning above their department's average
        // Important: First calculate each department's average.
        // Then compare every employee's salary with that average.
        // --------------------------------------------------

        System.out.println("\nQuestion 155:");

        Map<String, Double> departmentAverages =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        employees.stream()
                .filter(e -> e.getSalary() >
                        departmentAverages.get(e.getDepartment()))
                .forEach(e -> System.out.println(
                        e.getName() + " - " + e.getDepartment()
                                + " - " + e.getSalary()
                ));


        // --------------------------------------------------
        // Question 156: Find the youngest employee in each department
        // Important: The age list is aligned with employees by index.
        // Stream indexes are used to associate each employee with their age.
        // --------------------------------------------------

        System.out.println("\nQuestion 156:");

        Map<String, Integer> youngestAgeByDepartment =
                java.util.stream.IntStream.range(0, employees.size())
                        .boxed()
                        .collect(Collectors.groupingBy(
                                i -> employees.get(i).getDepartment(),
                                LinkedHashMap::new,
                                Collectors.mapping(
                                        ages::get,
                                        Collectors.minBy(Integer::compareTo)
                                )
                        ))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().orElse(-1),
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

        youngestAgeByDepartment.forEach((department, age) ->
                System.out.println(department + " -> " + age + " years"));


        // --------------------------------------------------
        // Question 157: Sort employees by multiple attributes
        // Important: Sort by department ascending, then salary descending,
        // then employee name ascending.
        // --------------------------------------------------

        System.out.println("\nQuestion 157:");

        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getDepartment)
                                .thenComparing(
                                        Comparator.comparingDouble(
                                                Employee::getSalary
                                        ).reversed()
                                )
                                .thenComparing(Employee::getName)
                )
                .forEach(e -> System.out.println(
                        e.getDepartment() + " - " + e.getName()
                                + " - " + e.getSalary()
                ));


        // --------------------------------------------------
        // Question 158: Find duplicate employee IDs
        // Important: IDs are separate from Employee in this example.
        // frequency > 1 identifies IDs that appear multiple times.
        // --------------------------------------------------

        System.out.println("\nQuestion 158:");

        Map<Integer, Long> idFrequency =
                employeeIds.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ));

        idFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(
                        "Duplicate ID: " + entry.getKey()
                                + ", Count: " + entry.getValue()
                ));


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


        // --------------------------------------------------
        // Question 160: Calculate payroll totals and statistics by department
        // Important: summarizingInt() calculates count, sum, min, max and average.
        // --------------------------------------------------

        System.out.println("\nQuestion 160:");

        Map<String, java.util.DoubleSummaryStatistics> payrollStatistics =
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