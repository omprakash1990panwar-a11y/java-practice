package interview.practice;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Day13 {

    public static void main(String[] args) {

        // Question 121: Find duplicate strings using groupingBy() and counting().
        // IMPORTANT:
        // groupingBy() groups equal strings.
        // counting() counts occurrences of each string.

        System.out.println("Question 121: Find duplicate strings");

        List<String> words = Arrays.asList(
                "Java", "Spring", "Java", "Docker",
                "Spring", "Java", "Microservices"
        );

        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Map<String, Long> duplicateWords = wordFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Duplicate strings: " + duplicateWords);


        // Question 122: Find elements that appear only once.
        // IMPORTANT:
        // Filter the frequency map for elements with a count of one.

        System.out.println("\nQuestion 122: Find elements that appear only once");

        List<String> uniqueWords = wordFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Elements appearing once: " + uniqueWords);


        // Question 123: Build a frequency map of integers.
        // IMPORTANT:
        // groupingBy() with counting() creates an element-frequency map.

        System.out.println("\nQuestion 123: Frequency map of integers");

        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 10, 40, 30
        );

        Map<Integer, Long> numberFrequency = numbers.stream()
                .collect(Collectors.groupingBy(
                        number -> number,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Integer frequency: " + numberFrequency);


        // Question 124: Build a frequency map of characters.
        // IMPORTANT:
        // chars() creates an IntStream of UTF-16 code units.
        // mapToObj() converts each value to a Character.

        System.out.println("\nQuestion 124: Frequency map of characters");

        String text = "programming";

        Map<Character, Long> characterFrequency = text.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(
                        character -> character,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Character frequency: " + characterFrequency);


        // Question 125: Merge duplicate keys with toMap().
        // IMPORTANT:
        // The merge function combines values when keys are repeated.
        // Here, each occurrence contributes one to the total count.

        System.out.println("\nQuestion 125: Merge duplicate keys with toMap()");

        List<String> products = Arrays.asList(
                "Apple", "Banana", "Apple", "Orange",
                "Banana", "Apple"
        );

        Map<String, Integer> productCount = products.stream()
                .collect(Collectors.toMap(
                        product -> product,
                        product -> 1,
                        (oldValue, newValue) -> oldValue + newValue,
                        LinkedHashMap::new
                ));

        System.out.println("Product count: " + productCount);


        // Question 126: Find the most frequent element.
        // IMPORTANT:
        // max() finds the entry with the greatest frequency.

        System.out.println("\nQuestion 126: Find the most frequent element");

        Map.Entry<Integer, Long> mostFrequent = numberFrequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (mostFrequent != null) {
            System.out.println("Most frequent element: "
                    + mostFrequent.getKey());
            System.out.println("Frequency: "
                    + mostFrequent.getValue());
        }


        // Question 127: Find the least frequent element.
        // IMPORTANT:
        // min() finds the entry with the smallest frequency.

        System.out.println("\nQuestion 127: Find the least frequent element");

        Map.Entry<Integer, Long> leastFrequent = numberFrequency.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        if (leastFrequent != null) {
            System.out.println("Least frequent element: "
                    + leastFrequent.getKey());
            System.out.println("Frequency: "
                    + leastFrequent.getValue());
        }


        // Employee data for Questions 128, 129 and 130.
        // IMPORTANT:
        // Ensure your Employee constructor accepts these four arguments
        // in this order: name, department, job title, salary.

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", "Developer", 60000),
                new Employee("Priya", "IT", "Tester", 50000),
                new Employee("Rahul", "IT", "Developer", 70000),
                new Employee("Neha", "HR", "Manager", 65000),
                new Employee("Karan", "HR", "Recruiter", 45000),
                new Employee("Sneha", "Finance", "Analyst", 55000)
        );


        // Question 128: Group employees by department and job title.
        // IMPORTANT:
        // groupingBy() cannot use null classification keys.
        // Filter employees with null department or job title values.
        // The outer map groups by department.
        // The inner map groups by job title.

        System.out.println(
                "\nQuestion 128: Group employees by department and job title"
        );

        Map<String, Map<String, List<Employee>>> employeesByDepartmentAndJob =
                employees.stream()
                        .filter(employee ->
                                employee.getDepartment() != null)
                        .filter(employee ->
                                employee.getJobTitle() != null)
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.groupingBy(
                                        Employee::getJobTitle,
                                        LinkedHashMap::new,
                                        Collectors.toList()
                                )
                        ));

        employeesByDepartmentAndJob.forEach((department, jobMap) -> {
            System.out.println(department + ":");

            jobMap.forEach((jobTitle, employeeList) ->
                    System.out.println("  " + jobTitle + " -> "
                            + employeeList.stream()
                            .map(Employee::getName)
                            .collect(Collectors.toList()))
            );
        });


        // Question 129: Group employees and collect their names.
        // IMPORTANT:
        // mapping() extracts employee names before collecting them.
        // Employees with null departments are excluded.

        System.out.println(
                "\nQuestion 129: Group employees and collect their names"
        );

        Map<String, List<String>> employeeNamesByDepartment =
                employees.stream()
                        .filter(employee ->
                                employee.getDepartment() != null)
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        ));

        System.out.println(
                "Employee names by department: "
                        + employeeNamesByDepartment
        );


        // Question 130: Produce a department-to-average-salary map.
        // IMPORTANT:
        // averagingDouble() calculates the average salary per department.
        // Employees with null departments are excluded.

        System.out.println(
                "\nQuestion 130: Department-to-average-salary map"
        );

        Map<String, Double> averageSalaryByDepartment =
                employees.stream()
                        .filter(employee ->
                                employee.getDepartment() != null)
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(
                                        Employee::getSalary
                                )
                        ));

        System.out.println(
                "Average salary by department: "
                        + averageSalaryByDepartment
        );
    }
}