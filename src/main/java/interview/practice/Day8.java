
package interview.practice;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Day8
{

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 15, 20, 25, 30, 35, 40, 45, 50
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000, Arrays.asList("Java", "Spring Boot"), 101, "IT"),
                new Employee("Priya", 60000, Arrays.asList("Recruitment", "Communication"), 102, "HR"),
                new Employee("Rahul", 55000, Arrays.asList("Java", "Microservices"), 103, "IT"),
                new Employee("Neha", 70000, Arrays.asList("Accounting", "Excel"), 104, "Finance"),
                new Employee("Vikas", 45000, Arrays.asList("Communication", "Payroll"), 105, "HR"),
                new Employee("Sneha", 80000, Arrays.asList("Cloud", "Docker"), 106, "IT"),
                new Employee("Karan", 65000, Arrays.asList("Accounting", "Reporting"), 107, "Finance")
        );


        // 071. Partition numbers into even and odd using partitioningBy().
        Map<Boolean, List<Integer>> evenOddPartition =
                numbers.stream()
                        .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        System.out.println("071. Even numbers: " + evenOddPartition.get(true));
        System.out.println("071. Odd numbers: " + evenOddPartition.get(false));


        // 072. Partition employees by a salary threshold of 60000.
        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                employee -> employee.getSalary() >= 60000
                        ));

        System.out.println("\n072. Employees earning 60000 or more: "
                + salaryPartition.get(true));
        System.out.println("072. Employees earning below 60000: "
                + salaryPartition.get(false));


        // 073. Use mapping() inside groupingBy() to collect employee names.
        Map<String, List<String>> employeeNamesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        ));

        System.out.println("\n073. Employee names by department: "
                + employeeNamesByDepartment);


        // 074. Use counting() inside groupingBy() to count employees.
        Map<String, Long> employeeCountByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println("\n074. Employee count by department: "
                + employeeCountByDepartment);


        // 075. Use summingInt() to total integer values by department.
        // Convert salary to int for this exercise.
        Map<String, Integer> totalSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingInt(
                                        employee -> (int) employee.getSalary()
                                )
                        ));

        System.out.println("\n075. Total salary by department: "
                + totalSalaryByDepartment);


        // 076. Use averagingInt() to calculate average salary by department.
        Map<String, Double> averageSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingInt(
                                        employee -> (int) employee.getSalary()
                                )
                        ));

        System.out.println("\n076. Average salary by department: "
                + averageSalaryByDepartment);


        // 077. Use summarizingInt() to calculate salary statistics.
        Map<String, IntSummaryStatistics> salaryStatisticsByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summarizingInt(
                                        employee -> (int) employee.getSalary()
                                )
                        ));

        System.out.println("\n077. Salary statistics by department:");
        salaryStatisticsByDepartment.forEach((department, statistics) ->
                System.out.println(department + " -> " + statistics));


        // 078. Use maxBy() inside groupingBy() to find the highest-paid employee.
        Map<String, Optional<Employee>> highestPaidByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Employee::getSalary)
                                )
                        ));

        System.out.println("\n078. Highest-paid employee by department:");
        highestPaidByDepartment.forEach((department, employee) ->
                System.out.println(department + " -> "
                        + employee.map(Employee::getName).orElse("Not found")));


        // 079. Use collectingAndThen() to get an unmodifiable list of names.
        List<String> unmodifiableNames =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        ));

        System.out.println("\n079. Unmodifiable employee names: "
                + unmodifiableNames);

        // Uncomment to test: this throws UnsupportedOperationException.
        // unmodifiableNames.add("New Employee");


        // 080. Compare groupingBy() and partitioningBy().
        Map<String, List<Employee>> groupedEmployees =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<Boolean, List<Employee>> partitionedEmployees =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                employee -> employee.getSalary() >= 60000
                        ));

        System.out.println("\n080. groupingBy() - groups by department:");
        groupedEmployees.forEach((department, employeeList) ->
                System.out.println(department + " -> " + employeeList));

        System.out.println("\n080. partitioningBy() - groups by salary threshold:");
        System.out.println("Salary >= 60000 -> "
                + partitionedEmployees.get(true));
        System.out.println("Salary < 60000 -> "
                + partitionedEmployees.get(false));
    }
}
