
package interview.practice;

import interview.UtilPackages.Employee;
import interview.UtilPackages.Transaction;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class Day19 {

    public static void main(String[] args) {

        /*
         * IMPORTANT NOTES:
         *
         * 1. Java 8 Stream API is used wherever suitable.
         * 2. Employee and Transaction are existing utility classes.
         * 3. No static inner classes or new utility classes are created.
         * 4. LinkedHashMap preserves insertion order.
         * 5. distinct() removes duplicate values from an ordered stream.
         * 6. groupingBy() groups elements by a selected property.
         * 7. Some challenges, such as the longest substring, are best solved
         *    with an algorithm using a loop and a map.
         */

        // Employee constructor:
        // Employee(String name, double salary, List<String> skills,
        //          int id, String department)

        Employee e1 = new Employee("Amit", 80000.0, null, 101, "IT");
        e1.setJobTitle("Developer");

        Employee e2 = new Employee("Priya", 60000.0, null, 102, "IT");
        e2.setJobTitle("Tester");

        Employee e3 = new Employee("Rahul", 90000.0, null, 103, "IT");
        e3.setJobTitle("Developer");

        Employee e4 = new Employee("Neha", 75000.0, null, 104, "HR");
        e4.setJobTitle("Manager");

        Employee e5 = new Employee("Karan", 50000.0, null, 105, "HR");
        e5.setJobTitle("Recruiter");

        Employee e6 = new Employee("Sneha", 70000.0, null, 106, "Finance");
        e6.setJobTitle("Analyst");

        Employee e7 = new Employee("Vikas", 65000.0, null, 107, "Finance");
        e7.setJobTitle("Accountant");

        Employee e8 = new Employee("Meera", 85000.0, null, 108, "IT");
        e8.setJobTitle("Developer");

        List<Employee> employees = Arrays.asList(
                e1, e2, e3, e4, e5, e6, e7, e8
        );


        // =========================================================
        // Question 181: Find the second-highest salary per department.
        //
        // Concept:
        // 1. Group employees by department.
        // 2. Extract salaries.
        // 3. Remove duplicate salaries.
        // 4. Sort in descending order.
        // 5. Skip the highest salary and find the next one.
        // =========================================================

        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        Map<String, Optional<Double>> secondHighestByDepartment =
                new LinkedHashMap<>();

        employeesByDepartment.forEach((department, departmentEmployees) -> {

            Optional<Double> secondHighest =
                    departmentEmployees.stream()
                            .map(Employee::getSalary)
                            .distinct()
                            .sorted(Comparator.reverseOrder())
                            .skip(1)
                            .findFirst();

            secondHighestByDepartment.put(department, secondHighest);
        });

        System.out.println("Q181 - Second-highest salary by department:");

        secondHighestByDepartment.forEach((department, salary) ->
                System.out.println(department + " -> " + salary)
        );


        // =========================================================
        // Question 182: Find the top three salaries per department.
        //
        // Concept:
        // Group by department, sort salaries descending, remove duplicates,
        // and limit the result to three salaries.
        // =========================================================

        Map<String, List<Double>> topThreeSalariesByDepartment =
                employeesByDepartment.entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue()
                                        .stream()
                                        .map(Employee::getSalary)
                                        .distinct()
                                        .sorted(Comparator.reverseOrder())
                                        .limit(3)
                                        .collect(Collectors.toList()),
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        ));

        System.out.println("\nQ182 - Top three salaries by department:");

        topThreeSalariesByDepartment.forEach((department, salaries) ->
                System.out.println(department + " -> " + salaries)
        );


        // =========================================================
        // Question 183: Find the most common word in a list of sentences.
        //
        // Concept:
        // flatMap() converts sentences into individual words.
        // Normalize case, remove punctuation, count words, and find the max.
        // =========================================================

        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "Java streams simplify collections",
                "Java is powerful and Java is popular"
        );

        Map<String, Long> wordFrequency = sentences.stream()
                .flatMap(sentence -> Arrays.stream(
                        sentence.toLowerCase()
                                .replaceAll("[^a-z0-9\\s]", "")
                                .split("\\s+")
                ))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Optional<Map.Entry<String, Long>> mostCommonWord =
                wordFrequency.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue());

        mostCommonWord.ifPresent(entry ->
                System.out.println("\nQ183 - Most common word: "
                        + entry.getKey() + " ("
                        + entry.getValue() + " occurrences)")
        );


        // =========================================================
        // Question 184: Group anagrams together.
        //
        // Concept:
        // Words that contain the same characters have the same sorted
        // character sequence. Use that sequence as the grouping key.
        // =========================================================

        List<String> words = Arrays.asList(
                "listen", "silent", "enlist",
                "rat", "tar", "art",
                "evil", "vile"
        );

        Map<String, List<String>> anagramGroups = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.chars()
                                .sorted()
                                .collect(
                                        StringBuilder::new,
                                        StringBuilder::appendCodePoint,
                                        StringBuilder::append
                                )
                                .toString(),
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        System.out.println("\nQ184 - Anagram groups:");

        anagramGroups.values().forEach(System.out::println);


        // =========================================================
        // Question 185: Find pairs of numbers whose sum equals a target.
        //
        // Concept:
        // Use flatMap() to examine combinations.
        // Only consider a < b to avoid reversed duplicate pairs.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;

        List<List<Integer>> pairs = numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a < b && a + b == target)
                        .map(b -> Arrays.asList(a, b)))
                .collect(Collectors.toList());

        System.out.println("\nQ185 - Pairs with sum " + target
                + ": " + pairs);


        // =========================================================
        // Question 186: Find the longest substring without duplicate characters.
        //
        // Concept:
        // Sliding-window algorithm.
        // A map records the last index of each character.
        // Move the window's left boundary when a duplicate is found.
        // =========================================================

        String input = "abcabcbb";

        Map<Character, Integer> lastSeenIndex = new HashMap<>();

        int left = 0;
        int longestLength = 0;
        int longestStart = 0;

        for (int right = 0; right < input.length(); right++) {

            char currentCharacter = input.charAt(right);

            if (lastSeenIndex.containsKey(currentCharacter)
                    && lastSeenIndex.get(currentCharacter) >= left) {

                left = lastSeenIndex.get(currentCharacter) + 1;
            }

            lastSeenIndex.put(currentCharacter, right);

            int currentLength = right - left + 1;

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestStart = left;
            }
        }

        String longestSubstring = input.substring(
                longestStart, longestStart + longestLength
        );

        System.out.println("\nQ186 - Input string: " + input);
        System.out.println("Q186 - Longest substring: " + longestSubstring);
        System.out.println("Q186 - Length: " + longestLength);


        // =========================================================
        // Question 187: Find duplicate transactions by transaction ID.
        //
        // Concept:
        // Group transactions by transaction ID, count each group,
        // and retain IDs appearing more than once.
        // =========================================================

        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, 1200.0, LocalDate.of(2026, 1, 5)),
                new Transaction(102, 800.0, LocalDate.of(2026, 1, 20)),
                new Transaction(101, 300.0, LocalDate.of(2026, 2, 2)),
                new Transaction(103, 1500.0, LocalDate.of(2026, 2, 10)),
                new Transaction(103, 500.0, LocalDate.of(2026, 1, 30))
        );

        Map<Integer, Long> transactionIdCounts = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getTransactionId,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Map<Integer, Long> duplicateTransactionIds =
                transactionIdCounts.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        ));

        System.out.println("\nQ187 - Duplicate transaction IDs: "
                + duplicateTransactionIds);


        // =========================================================
        // Question 188: Group transactions by month and calculate totals.
        //
        // Concept:
        // YearMonth combines the year and month, preventing January
        // from different years from being incorrectly grouped together.
        // summingDouble() calculates the total for each month.
        // =========================================================

        Map<YearMonth, Double> monthlyTransactionTotals =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                transaction ->
                                        YearMonth.from(transaction.getDate()),
                                TreeMap::new,
                                Collectors.summingDouble(
                                        Transaction::getAmount
                                )
                        ));

        System.out.println("\nQ188 - Monthly transaction totals:");

        monthlyTransactionTotals.forEach((month, total) ->
                System.out.println(month + " -> " + total)
        );


        // =========================================================
        // Question 189: Find employees whose salaries exceed
        // the overall average salary.
        //
        // Concept:
        // First calculate the overall average, then filter employees
        // whose salaries are strictly greater than that average.
        // =========================================================

        double overallAverageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        List<String> employeesAboveAverage = employees.stream()
                .filter(employee ->
                        employee.getSalary() > overallAverageSalary)
                .map(employee ->
                        employee.getName() + " - "
                                + employee.getSalary())
                .collect(Collectors.toList());

        System.out.println("\nQ189 - Overall average salary: "
                + overallAverageSalary);

        System.out.println("Q189 - Employees earning above average: "
                + employeesAboveAverage);


        // =========================================================
        // Question 190: Build a nested department-to-job-title
        // employee count map.
        //
        // Concept:
        // Outer groupingBy() groups employees by department.
        // Inner groupingBy() groups each department by job title.
        // counting() counts employees in each group.
        // =========================================================

        Map<String, Map<String, Long>> departmentJobTitleCounts =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.groupingBy(
                                        Employee::getJobTitle,
                                        LinkedHashMap::new,
                                        Collectors.counting()
                                )
                        ));

        System.out.println("\nQ190 - Department to job-title employee counts:");

        departmentJobTitleCounts.forEach((department, jobTitleCounts) ->
                System.out.println(department + " -> " + jobTitleCounts)
        );
    }
}
