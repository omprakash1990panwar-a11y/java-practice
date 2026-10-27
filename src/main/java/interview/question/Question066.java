package interview.question;

import interview.UtilPackages.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question066 {

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

        // 066. Calculate total salary by department using summingDouble().
        Map<String, Double> totalSalaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary)
                        ));

        System.out.println("\n066. Total salary by department using summingDouble:");
        totalSalaryByDepartment.forEach((department, totalSalary) ->
                System.out.println(department + " -> " + totalSalary));

        // 066. Calculate total salary by department using reduce ().
        Map<String, Double> totalSalaryByDepartment2 =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.reducing(0.0,Employee::getSalary,Double::sum)
                                ));

        System.out.println("\n066. Total salary by department using reducing:");
        totalSalaryByDepartment2.forEach((department, totalSalary) ->
                System.out.println(department + " -> " + totalSalary));

    }
}
