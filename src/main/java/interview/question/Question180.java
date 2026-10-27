package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question180 {
    public static void main(String[] args) {
        // =========================================================
        // Question 180: Identify unsafe shared mutable state in parallel streams.
        // Concept: modifying a shared ArrayList from parallel forEach()
        // is unsafe because ArrayList is not thread-safe.
        //
        // UNSAFE EXAMPLE — DO NOT RUN:
        //
        // List<Integer> unsafeList = new ArrayList<>();
        // numbers.parallelStream().forEach(unsafeList::add);
        //
        // This can cause data races, lost updates, or inconsistent results.
        //
        // SAFE APPROACH: use a collector to manage accumulation.
        // =========================================================

        List<Employee> workers = Arrays.asList(
                new Employee("Amit", "IT", 80000, "amit@example.com"),
                new Employee("Priya", "HR", 60000, "priya@example.com"),
                new Employee("Rahul", "IT", 90000, "rahul@example.com"),
                new Employee("Neha", "HR", 75000, "neha@example.com"),
                new Employee("Karan", "HR", 50000, "karan@example.com")
        );

        List<Employee> parallelResult = workers.parallelStream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .collect(Collectors.toList());

        System.out.println("Q180 - Result: " + parallelResult);
    }
}