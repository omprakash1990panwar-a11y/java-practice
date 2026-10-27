package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question196 {
    public static void main(String[] args) {

        // =========================================================
        // Question 196: Explain reduce() versus collect().
        //
        // reduce() combines values into a single result.
        // collect() accumulates values into a mutable result container.
        //
        // Examples:
        // reduce() -> sum of numbers.
        // collect() -> list of employee names.
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


        List<Integer> numbers =
                Arrays.asList(10, 30, 20, 30, 40, 20, 50);


        Integer base =0;

        int sumUsingReduce = numbers.stream()
                .reduce(base, Integer::sum);

        List<String> namesUsingCollect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nQ196 - Sum using reduce(): "
                + sumUsingReduce);

        System.out.println("Q196 - Names using collect(): "
                + namesUsingCollect);

    }
}
