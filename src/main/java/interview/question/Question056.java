package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question056 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000, Arrays.asList("Java", "Spring Boot"), 101, "IT"),
                new Employee("Priya", 60000, Arrays.asList("Recruitment", "Communication"), 102, "HR"),
                new Employee("Rahul", 55000, Arrays.asList("Java", "Microservices"), 103, "IT"),
                new Employee("Neha", 70000, Arrays.asList("Accounting", "Excel"), 104, "Finance"),
                new Employee("Amit", 65000, Arrays.asList("Sales", "Negotiation"), 105, "Sales")
        );

        // 056. Create a Map of Employee Name to Salary
        // If names repeat, keep the last encountered salary.
        Map<String, Double> employeeSalaryMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary,
                        (oldSalary, newSalary) -> newSalary
                ));

        System.out.println("\n056. Employee Name to Salary:\n" + employeeSalaryMap);
    }
}
