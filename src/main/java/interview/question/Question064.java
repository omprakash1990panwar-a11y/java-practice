package interview.question;

import interview.UtilPackages.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question064 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 70000, LocalDate.of(1995, 5, 10)),
                new Employee(2, "Priya", "HR", 60000, LocalDate.of(1993, 8, 15)),
                new Employee(3, "Rahul", "IT", 90000, LocalDate.of(1990, 3, 20)),
                new Employee(4, "Neha", "Finance", 75000, LocalDate.of(1997, 1, 12)),
                new Employee(5, "Vikas", "HR", 65000, LocalDate.of(1992, 7, 25)),
                new Employee(6, "Sneha", "Finance", 85000, LocalDate.of(1994, 11, 5)),
                new Employee(7, "Karan", "IT", 80000, LocalDate.of(1991, 9, 18))
        );

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
    }
}
