package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;

public class Question199 {
    public static void main(String[] args) {


        // =========================================================
        // Question 199: Explain performance trade-offs in parallel streams.
        //
        // Parallel streams may help for sufficiently large workloads
        // with independent operations and enough CPU resources.
        //
        // They may be slower for small lists because of splitting,
        // scheduling, coordination, and combining results.
        //
        // Avoid shared mutable state. Preserve ordering only when needed.
        // Benchmark representative workloads instead of assuming that
        // parallelStream() is always faster.
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

        double sequentialTotal = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double parallelTotal = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("\nQ199 - Sequential total: "
                + sequentialTotal);

        System.out.println("Q199 - Parallel total: "
                + parallelTotal);

        System.out.println("Q199 - Both approaches should produce "
                + "the same total for this data.");

    }
}
