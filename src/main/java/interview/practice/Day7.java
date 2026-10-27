package interview.practice;

import interview.UtilPackages.Employee;
import interview.UtilPackages.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Day7 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 70000,  LocalDate.of(1995, 5, 10)),
                new Employee(2, "Priya", "HR", 60000, LocalDate.of(1993, 8, 15)),
                new Employee(3, "Rahul", "IT", 90000,  LocalDate.of(1990, 3, 20)),
                new Employee(4, "Neha", "Finance", 75000, LocalDate.of(1997, 1, 12)),
                new Employee(5, "Vikas", "HR", 65000, LocalDate.of(1992, 7, 25)),
                new Employee(6, "Sneha", "Finance", 85000, LocalDate.of(1994, 11, 5)),
                new Employee(7, "Karan", "IT", 80000,  LocalDate.of(1991, 9, 18))
        );

        List<String> words = Arrays.asList(
                "Java", "SQL", "Spring", "API", "Docker",
                "Code", "Stream", "Go", "Python", "AI"
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, 1500, LocalDate.of(2022, 3, 10)),
                new Transaction(102, 2500, LocalDate.of(2023, 6, 15)),
                new Transaction(103, 1800, LocalDate.of(2022, 9, 20)),
                new Transaction(104, 3200, LocalDate.of(2024, 1, 5)),
                new Transaction(105, 2100, LocalDate.of(2023, 11, 25)),
                new Transaction(106, 4000, LocalDate.of(2024, 8, 12))
        );


        // 061. Group employees by department using groupingBy().
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("061. Employees grouped by department:");
        employeesByDepartment.forEach((department, employeeList) ->
                System.out.println(department + " -> " + employeeList));


        // 062. Count employees in each department using counting().
        Map<String, Long> employeeCountByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println("\n062. Employee count by department:");
        employeeCountByDepartment.forEach((department, count) ->
                System.out.println(department + " -> " + count));


        // 063. Find average salary by department using averagingDouble().
        Map<String, Double> averageSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println("\n063. Average salary by department:");
        averageSalaryByDepartment.forEach((department, averageSalary) ->
                System.out.println(department + " -> " + averageSalary));


        // 064. Find maximum salary in each department using maxBy().
        Map<String, Optional<Employee>> maximumSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Employee::getSalary)
                                )
                        ));

        System.out.println("\n064. Highest-paid employee in each department:");
        maximumSalaryByDepartment.forEach((department, employee) ->
                System.out.println(department + " -> "
                        + employee.map(Employee::getSalary).orElse(0.0)));


        // 065. Find minimum salary in each department using minBy().
        Map<String, Optional<Employee>> minimumSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.minBy(
                                        Comparator.comparingDouble(Employee::getSalary)
                                )
                        ));

        System.out.println("\n065. Lowest-paid employee in each department:");
        minimumSalaryByDepartment.forEach((department, employee) ->
                System.out.println(department + " -> "
                        + employee.map(Employee::getSalary).orElse(0.0)));


        // 066. Calculate total salary by department using summingDouble().
        Map<String, Double> totalSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary)
                        ));

        System.out.println("\n066. Total salary by department:");
        totalSalaryByDepartment.forEach((department, totalSalary) ->
                System.out.println(department + " -> " + totalSalary));


        // 067. Group strings by their length using groupingBy().
        Map<Integer, List<String>> wordsByLength =
                words.stream()
                        .collect(Collectors.groupingBy(String::length));

        System.out.println("\n067. Words grouped by length:");
        wordsByLength.forEach((length, wordList) ->
                System.out.println(length + " -> " + wordList));


        // 068. Group words by their first character using groupingBy().
        Map<Character, List<String>> wordsByFirstCharacter =
                words.stream()
                        .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println("\n068. Words grouped by first character:");
        wordsByFirstCharacter.forEach((firstCharacter, wordList) ->
                System.out.println(firstCharacter + " -> " + wordList));


        // 069. Group transactions by year using groupingBy().
        Map<Integer, List<Transaction>> transactionsByYear =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                transaction -> transaction.getDate().getYear()
                        ));

        System.out.println("\n069. Transactions grouped by year:");
        transactionsByYear.forEach((year, transactionList) ->
                System.out.println(year + " -> " + transactionList));


        // 070. Find the highest-paid employee in each department.
        Map<String, Employee> highestPaidEmployeeByDepartment =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getDepartment,
                                employee -> employee,
                                (employee1, employee2) ->
                                        employee1.getSalary() >= employee2.getSalary()
                                                ? employee1 : employee2
                        ));

        System.out.println("\n070. Highest-paid employee by department:");
        highestPaidEmployeeByDepartment.forEach((department, employee) ->
                System.out.println(department + " -> " + employee));
    }
}
