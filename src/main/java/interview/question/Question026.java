package interview.question;

import interview.UtilPackages.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question026 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                40, 10, 30, 20, 50, 20, 60, 10, 70
        );


        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2025, 12, 25),
                LocalDate.of(2023, 5, 10),
                LocalDate.of(2024, 8, 15),
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2024, 2, 20)
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", 60000),
                new Employee("Amit", 50000),
                new Employee("Priya", 60000),
                new Employee("Neha", 40000),
                new Employee("Vikas", 50000)
        );


        // Question 026: Use Function.identity() to keep the original name as the key.
        // Function.identity() returns a function that returns its input unchanged.
        Map<String, Integer> nameCharacterCounts = names.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("Q026 - Name counts using identity(): " + nameCharacterCounts);


        // Find the second-highest distinct number.

        Integer secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Not enough distinct numbers"));

        System.out.println(
                "Q026 - Second-highest distinct number: "
                        + secondHighest);




        // Find the third-highest distinct number.

        Integer thirdHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Not enough distinct numbers"));

        System.out.println(
                "Q027 - Third-highest distinct number: "
                        + thirdHighest);

        List<LocalDate> sortedDates = dates.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Q029 - Dates descending:");

        sortedDates.forEach(System.out::println);


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
