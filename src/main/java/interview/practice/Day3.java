
package interview.practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {

        // Question 021: Sort strings alphabetically.
        // sorted() uses the natural alphabetical ordering of strings.
        List<String> names = Arrays.asList(
                "Rahul", "Amit", "Priya", "Neha", "Vikas"
        );

        List<String> alphabetical = names.stream()
                .sorted()
                .toList();

        System.out.println("Q021 - Alphabetical order: " + alphabetical);

        // Question 022: Sort strings by length.
        // comparingInt(String::length) sorts from shortest to longest.
        List<String> lengthSorted = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println("Q022 - Sorted by length: " + lengthSorted);

        // Alternative: sort by length using a lambda expression.
        List<String> lengthSortedLambda = names.stream()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .toList();

        System.out.println("Q022 - Length sorting using lambda: "
                + lengthSortedLambda);

        // Question 023: Sort employees by salary in ascending order.
        // comparingDouble() compares employee salaries from lowest to highest.
        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", 60000),
                new Employee("Amit", 40000),
                new Employee("Priya", 80000),
                new Employee("Omy", 100000)
        );

        List<Employee> salaryAscending = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList();

        System.out.println("Q023 - Salary ascending: " + salaryAscending);

        // Alternative: sort employees by salary in descending order using a lambda.
        List<Employee> salaryDescendingLambda = employees.stream()
                .sorted((a, b) ->
                        Double.compare(b.getSalary(), a.getSalary()))
                .toList();

        System.out.println("Q023 - Salary descending using lambda: "
                + salaryDescendingLambda);

        // Question 024: Sort workers by department, then salary.
        // thenComparingInt() sorts by salary when departments are equal.
        List<Worker> workers = Arrays.asList(
                new Worker("Rahul", "IT", 60000),
                new Worker("Amit", "HR", 40000),
                new Worker("Priya", "IT", 50000),
                new Worker("Neha", "HR", 45000)
        );

        List<Worker> sortedWorkers = workers.stream()
                .sorted(Comparator.comparing(Worker::getDepartment)
                        .thenComparingInt(Worker::getSalary))
                .toList();

        System.out.println("Q024 - Department then salary: " + sortedWorkers);

        // Question 025: Sort strings in reverse alphabetical order.
        // reverseOrder() reverses the natural alphabetical ordering.
        List<String> reverseAlphabetical = names.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Q025 - Reverse alphabetical: "
                + reverseAlphabetical);

        // Additional: reverse-sort names and then convert them to uppercase.
        List<String> reverseUppercase = names.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .toList();

        System.out.println("Additional - Reverse sorted uppercase names: "
                + reverseUppercase);

        // Question 026: Find the second-highest distinct number.
        // distinct() removes duplicates; reverseOrder() puts the largest first.
        List<Integer> numbers = Arrays.asList(
                40, 10, 30, 20, 50, 20, 60, 10, 70
        );

        Integer secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Not enough distinct numbers"));

        System.out.println("Q026 - Second-highest distinct number: "
                + secondHighest);

        // Question 027: Find the third-highest distinct number.
        // skip(2) skips the highest two distinct values.
        Integer thirdHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Not enough distinct numbers"));

        System.out.println("Q027 - Third-highest distinct number: "
                + thirdHighest);

        // Question 028: Find the smallest three distinct numbers.
        // distinct() removes duplicates, sorted() orders ascending,
        // and limit(3) retains the first three elements.
        List<Integer> smallestThree = numbers.stream()
                .distinct()
                .sorted()
                .limit(3)
                .toList();

        System.out.println("Q028 - Smallest three distinct numbers: "
                + smallestThree);

        // Question 029: Sort dates in descending chronological order.
        // LocalDate values use natural chronological ordering;
        // reverseOrder() puts the latest date first.
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2025, 12, 25),
                LocalDate.of(2023, 5, 10),
                LocalDate.of(2024, 8, 15),
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2024, 2, 20)
        );

        List<LocalDate> sortedDates = dates.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Q029 - Dates descending:");

        sortedDates.forEach(System.out::println);

        // Question 030: Sort employees by salary descending,
        // then employee name ascending when salaries are equal.
        List<Employee> employees30 = Arrays.asList(
                new Employee("Rahul", 60000),
                new Employee("Amit", 50000),
                new Employee("Priya", 60000),
                new Employee("Neha", 40000),
                new Employee("Vikas", 50000)
        );

        List<Employee> sortedEmployees30 = employees30.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName))
                .toList();

        System.out.println("Q030 - Salary descending, name ascending:");

        sortedEmployees30.forEach(System.out::println);

        // Additional: sort strings by descending length.
        // Alphabetical ordering resolves ties between equal-length strings.
        List<String> descendingLength = names.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .toList();

        System.out.println("Additional - Length descending: "
                + descendingLength);

        // Additional: sort numbers using an explicit descending comparator.
        List<Integer> descendingNumbers = numbers.stream()
                .sorted((a, b) -> b.compareTo(a))
                .toList();

        System.out.println("Additional - Numbers descending: "
                + descendingNumbers);
    }


    // Supporting model class for Questions 023 and 030.
    // Stores an employee's name and salary.
    static class Employee {

        private final String name;
        private final double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', salary=" + salary + "}";
        }
    }


    // Supporting model class for Question 024.
    // Stores a worker's name, department and salary.
    static class Worker {

        private final String name;
        private final String department;
        private final int salary;

        Worker(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Worker{name='" + name
                    + "', department='" + department
                    + "', salary=" + salary + "}";
        }
    }
}
