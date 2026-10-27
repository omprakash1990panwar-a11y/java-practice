package interview.question;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Question195 {
    public static void main(String[] args) {

        // =========================================================
        // Question 195: Group employees and find department salary statistics.
        //
        // Concept:
        // groupingBy() groups employees by department.
        // summarizingDouble() calculates count, sum, min, max, average.
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


        Map<String, DoubleSummaryStatistics> departmentSalaryStatistics =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.summarizingDouble(
                                        Employee::getSalary
                                )
                        ));

        System.out.println("\nQ195 - Department salary statistics:");

        departmentSalaryStatistics.forEach((department, stats) ->
                System.out.println(department
                        + " -> count=" + stats.getCount()
                        + ", sum=" + stats.getSum()
                        + ", min=" + stats.getMin()
                        + ", max=" + stats.getMax()
                        + ", average=" + stats.getAverage())
        );
    }
}
