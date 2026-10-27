package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question191 {
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


    }
}
