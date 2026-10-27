package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;

public class Question198 {
    public static void main(String[] args) {

        // =========================================================
        // Question 198: Refactor a loop-based program into a stream pipeline.
        //
        // Original loop:
        // Find the total salary of employees in the IT department.
        //
        // Stream refactoring:
        // filter() selects IT employees and mapToDouble().sum()
        // calculates their total salary.
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

        double itSalaryUsingLoop = 0;

        for (Employee employee : employees) {
            if ("IT".equals(employee.getDepartment())) {
                itSalaryUsingLoop += employee.getSalary();
            }
        }

        double itSalaryUsingStream = employees.stream()
                .filter(employee ->
                        "IT".equals(employee.getDepartment()))
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("\nQ198 - IT salary using loop: "
                + itSalaryUsingLoop);

        System.out.println("Q198 - IT salary using stream: "
                + itSalaryUsingStream);

    }
}
