
package interview.practice;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Day20 {

    public static void main(String[] args) {

        /*
         * IMPORTANT NOTES:
         *
         * 1. filter() selects elements based on a condition.
         * 2. map() transforms one element into another element.
         * 3. flatMap() transforms each element into a stream and flattens
         *    all resulting streams into one stream.
         * 4. reduce() combines elements into one result.
         * 5. collect() accumulates elements into a collection or summary.
         * 6. DoubleSummaryStatistics calculates count, sum, min, max, average.
         * 7. Prefer clear, maintainable pipelines over unnecessarily complex streams.
         * 8. This class uses the existing Employee utility class.
         */

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

        // =========================================================
        // Question 191: Explain and implement filter(), map(), flatMap().
        //
        // filter()  -> selects employees earning at least 70000.
        // map()     -> converts employee names to uppercase.
        // flatMap() -> flattens all employee skill lists into one stream.
        // =========================================================

        List<String> highSalaryEmployeeNames = employees.stream()
                .filter(employee -> employee.getSalary() >= 70000)
                .map(employee -> employee.getName().toUpperCase())
                .collect(Collectors.toList());

        List<String> allUniqueSkills = employees.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Q191 - Employees earning at least 70000: "
                + highSalaryEmployeeNames);

        System.out.println("Q191 - Unique employee skills: "
                + allUniqueSkills);


        // =========================================================
        // Question 192: Implement frequency counting without external libraries.
        //
        // Concept:
        // Split text into words, normalize case, and use groupingBy()
        // with counting() to calculate each word's frequency.
        // =========================================================

        String text = "Java Stream Java Map Stream Java";

        Map<String, Long> wordFrequency = Arrays.stream(
                        text.toLowerCase().split("\\s+"))
                .collect(
                        Collectors.groupingBy((word) -> word, LinkedHashMap::new,Collectors.counting()
                ));

        System.out.println("\nQ192 - Word frequencies: " + wordFrequency);


        // =========================================================
        // Question 193: Find the top three most frequent words.
        //
        // Concept:
        // Count words, sort map entries by frequency descending,
        // and limit the result to three entries.
        // =========================================================

        String sentences =
                "java stream java map stream java filter map stream";

        Map<String, Long> frequencies = Arrays.stream(
                        sentences.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Map<String, Long> topThreeWords = frequencies.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("\nQ193 - Top three frequent words: "
                + topThreeWords);


        // =========================================================
        // Question 194: Find the Nth-highest distinct number.
        //
        // Concept:
        // distinct() removes duplicates, reverse sorting puts the
        // highest number first, and skip(n - 1) selects the Nth value.
        // =========================================================

        List<Integer> numbers =
                Arrays.asList(10, 30, 20, 30, 40, 20, 50);

        int n = 3;

        Optional<Integer> nthHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst();

        if (nthHighest.isPresent()) {
            System.out.println("\nQ194 - " + n
                    + "rd highest distinct number: " + nthHighest.get());
        } else {
            System.out.println("\nQ194 - There are fewer than "
                    + n + " distinct numbers.");
        }


        // =========================================================
        // Question 195: Group employees and find department salary statistics.
        //
        // Concept:
        // groupingBy() groups employees by department.
        // summarizingDouble() calculates count, sum, min, max, average.
        // =========================================================

        Map<String, DoubleSummaryStatistics> departmentSalaryStatistics =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.summarizingDouble(
                                        Employee::getSalary
                                )
                        ));

        System.out.println("\nQ195 - Department salary statistics:");

        departmentSalaryStatistics.forEach((department, stats) ->
                System.out.println(department
                        + " -> count=" + stats.getCount()
                        + ", sum=" + stats.getSum()
                        + ", min=" + stats.getMin()
                        + ", max=" + stats.getMax()
                        + ", average=" + stats.getAverage())
        );


        // =========================================================
        // Question 196: Explain reduce() versus collect().
        //
        // reduce() combines values into a single result.
        // collect() accumulates values into a mutable result container.
        //
        // Examples:
        // reduce() -> sum of numbers.
        // collect() -> list of employee names.
        // =========================================================

        int sumUsingReduce = numbers.stream()
                .reduce(0, Integer::sum);

        List<String> namesUsingCollect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nQ196 - Sum using reduce(): "
                + sumUsingReduce);

        System.out.println("Q196 - Names using collect(): "
                + namesUsingCollect);


        // =========================================================
        // Question 197: Debug an incorrect stream pipeline.
        //
        // Common mistake:
        //
        // employees.stream()
        //     .map(Employee::getSalary)
        //     .filter(employee -> employee.getSalary() > 70000)
        //
        // This does not compile because map() has already converted
        // each Employee into a double salary.
        //
        // Correct approach:
        // Filter Employee objects first, then map to names.
        // =========================================================

        List<String> correctedPipeline = employees.stream()
                .filter(employee -> employee.getSalary() > 70000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nQ197 - Corrected pipeline result: "
                + correctedPipeline);


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


        // =========================================================
        // Question 200: Solve an employee analytics problem and
        // explain time and space complexity.
        //
        // Problem:
        // 1. Calculate the overall average salary.
        // 2. Find employees earning above that average.
        // 3. Find the highest-paid employee in each department.
        //
        // Complexity:
        // Average calculation: O(E)
        // Filtering employees: O(E)
        // Grouping and finding department maxima: O(E)
        // Overall time: O(E), assuming hash-based grouping.
        // Auxiliary space: O(E) for the grouped results and output.
        // E = number of employees.
        // =========================================================

        double overallAverage = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        List<String> aboveAverageEmployees = employees.stream()
                .filter(employee ->
                        employee.getSalary() > overallAverage)
                .map(employee ->
                        employee.getName() + " (" + employee.getSalary() + ")")
                .collect(Collectors.toList());

        Map<String, Optional<Employee>> highestPaidByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                LinkedHashMap::new,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(
                                                Employee::getSalary
                                        )
                                )
                        ));

        Map<String, String> highestPaidNames = new LinkedHashMap<>();

        highestPaidByDepartment.forEach((department, employeeOptional) ->
                employeeOptional.ifPresent(employee ->
                        highestPaidNames.put(
                                department,
                                employee.getName() + " ("
                                        + employee.getSalary() + ")"
                        )
                )
        );

        System.out.println("\nQ200 - Overall average salary: "
                + overallAverage);

        System.out.println("Q200 - Employees earning above average: "
                + aboveAverageEmployees);

        System.out.println("Q200 - Highest-paid employee by department: "
                + highestPaidNames);
    }
}
