package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question030 {
    public static void main(String[] args) {


            List<Employee> employees = Arrays.asList(
                    new Employee("Rahul", 60000),
                    new Employee("Amit", 50000),
                    new Employee("Priya", 60000),
                    new Employee("Neha", 40000),
                    new Employee("Vikas", 50000)
            );

            List<Employee> sortedEmployees = employees.stream()
                    .sorted(
                            Comparator.comparingDouble(Employee::getSalary)
                                    .reversed()
                                    .thenComparing(Employee::getName)
                    )
                    .toList();

            System.out.println(
                    "Q030 - Salary descending, name ascending:");

            sortedEmployees.forEach(System.out::println);

    }
}
