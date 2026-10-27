package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question055 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000, Arrays.asList("Java", "Spring Boot"), 101, "IT"),
                new Employee("Priya", 60000, Arrays.asList("Recruitment", "Communication"), 102, "HR"),
                new Employee("Rahul", 55000, Arrays.asList("Java", "Microservices"), 103, "IT"),
                new Employee("Neha", 70000, Arrays.asList("Accounting", "Excel"), 104, "Finance"),
                new Employee("Amit", 65000, Arrays.asList("Sales", "Negotiation"), 105, "Sales")
        );

        // 055. Create a Map of Employee ID to Employee
        Map<Integer, Employee> employeeIdMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));

        System.out.println("\n055. Employee ID to Employee:\n" + employeeIdMap);
    }
}
