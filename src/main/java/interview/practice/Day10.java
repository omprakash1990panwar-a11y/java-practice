package interview.practice;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day10 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 50, 20, 80, 30, 100, 40, 90, 60, 70, 100
        );

        List<String> strings = Arrays.asList(
                "Rahul", "Amit", "Priya", "Neha",
                "Karan", "Ankit", "Zoya", "Deepak"
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering",
                        90000, "alice@example.com"),
                new Employee("Bob", "HR",
                        60000, "bob@example.com"),
                new Employee("Charlie", "Engineering",
                        75000, "charlie@example.com"),
                new Employee("Diana", "Finance",
                        50000, "diana@example.com"),
                new Employee("Ethan", "HR",
                        65000, "ethan@example.com"),
                new Employee("Frank", "Engineering",
                        120000, "frank@example.com"),
                new Employee("Grace", "Finance",
                        95000, "grace@example.com"),
                new Employee("Helen", "HR",
                        85000, "helen@example.com"),
                new Employee("Ian", "Engineering",
                        110000, "ian@example.com"),
                new Employee("Julia", "Finance",
                        80000, "julia@example.com"),
                new Employee("Kevin", "HR",
                        75000, "kevin@example.com"),
                new Employee("Laura", "Engineering",
                        100000, "laura@example.com")
        );

        // =====================================================
        // Q091. Find the top three highest numbers.
        //
        // IMPORTANT NOTES:
        // 1. sorted() sorts the elements in ascending order by default.
        // 2. Comparator.reverseOrder() sorts numbers in descending order.
        // 3. limit(3) returns at most the first three sorted elements.
        // 4. Duplicate numbers are retained unless distinct() is used.
        // 5. This question asks for the top three elements, not distinct
        //    values, so duplicate numbers are allowed.
        // =====================================================

        List<Integer> topThreeNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Q091. Top three highest numbers: "
                + topThreeNumbers);


        // =====================================================
        // Q092. Find the top five highest-paid employees.
        //
        // IMPORTANT NOTES:
        // 1. comparingInt() compares employees using their salary.
        // 2. reversed() changes the salary order to descending.
        // 3. limit(5) selects the five highest-paid employees.
        // 4. Employee::getSalary is a method reference.
        // 5. If salaries are equal, their relative order is not
        //    explicitly specified by this comparator.
        // =====================================================

        List<Employee> topFiveEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nQ092. Top five highest-paid employees: "
                + topFiveEmployees);


        // =====================================================
        // Q093. Implement pagination using skip() and limit().
        //
        // IMPORTANT NOTES:
        // 1. Pagination divides records into smaller pages.
        // 2. Page numbers start from 1 in this example.
        // 3. skip((pageNumber - 1) * pageSize) skips previous pages.
        // 4. limit(pageSize) restricts the number of records per page.
        // 5. Page 1 skips 0 records; page 2 skips 3 records when
        //    the page size is 3.
        // 6. Pagination here follows the original list order.
        // =====================================================

        int pageNumber = 2;
        int pageSize = 3;

        List<Employee> employeePage = employees.stream()
                .skip((pageNumber - 1L) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        System.out.println("\nQ093. Employees on page " + pageNumber
                + ": " + employeePage);


        // =====================================================
        // Q094. Find the second-lowest distinct number.
        //
        // IMPORTANT NOTES:
        // 1. distinct() removes duplicate numbers.
        // 2. sorted() arranges the distinct numbers in ascending order.
        // 3. skip(1) skips the lowest distinct number.
        // 4. findFirst() returns the next number, if present.
        // 5. Optional<Integer> handles the case where no result exists.
        // 6. orElse(null) returns null if the Optional is empty.
        // =====================================================

        Optional<Integer> secondLowest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();

        System.out.println("\nQ094. Second-lowest distinct number: "
                + secondLowest.orElse(null));


        // =====================================================
        // Q095. Find the Nth-highest salary.
        //
        // IMPORTANT NOTES:
        // 1. map() converts each Employee into a salary.
        // 2. distinct() ranks unique salary values.
        // 3. reverseOrder() sorts salaries from highest to lowest.
        // 4. skip(n - 1) skips the first N-1 salary values.
        // 5. findFirst() returns the Nth-highest distinct salary.
        // 6. If fewer than N distinct salaries exist, the result
        //    is an empty Optional.
        // =====================================================

        int n = 3;

        Optional<Double> nthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1L)
                .findFirst();

        System.out.println("\nQ095. " + n
                + "rd highest distinct salary: "
                + nthHighestSalary.orElse(null));


        // =====================================================
        // Q096. Get the first five strings alphabetically.
        //
        // IMPORTANT NOTES:
        // 1. sorted() uses the natural ordering of String.
        // 2. String natural ordering is case-sensitive.
        // 3. limit(5) selects the first five sorted strings.
        // 4. collect(toList()) collects the results into a List.
        // 5. Sort before limit() to get the alphabetically first
        //    five strings from the entire input list.
        // =====================================================

        List<String> firstFiveStrings = strings.stream()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nQ096. First five strings alphabetically: "
                + firstFiveStrings);


        // =====================================================
        // Q097. Skip the first three elements.
        //
        // IMPORTANT NOTES:
        // 1. skip(3) discards the first three encountered elements.
        // 2. The remaining elements preserve encounter order.
        // 3. skip() does not sort the list.
        // 4. If the stream has three or fewer elements, the result
        //    is an empty stream.
        // =====================================================

        List<Integer> remainingNumbers = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());

        System.out.println("\nQ097. Numbers after skipping first three: "
                + remainingNumbers);


        // =====================================================
        // Q098. Find the highest-paid three employees per department.
        //
        // IMPORTANT NOTES:
        // 1. groupingBy() groups employees by department.
        // 2. Each department gets its own employee list.
        // 3. collectingAndThen() transforms the collected list.
        // 4. Inside each group, sort salaries in descending order.
        // 5. limit(3) selects up to three employees per department.
        // 6. TreeMap keeps department names in sorted order.
        // 7. This example assumes department names are not null.
        // =====================================================

        Map<String, List<Employee>> topThreePerDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                java.util.TreeMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        departmentEmployees ->
                                                departmentEmployees.stream()
                                                        .sorted(
                                                                Comparator
                                                                        .comparingDouble(
                                                                                Employee::getSalary)
                                                                        .reversed()
                                                        )
                                                        .limit(3)
                                                        .collect(
                                                                Collectors.toList()
                                                        )
                                )
                        ));

        System.out.println("\nQ098. Top three highest-paid employees "
                + "per department:");

        topThreePerDepartment.forEach((department, employeeList) ->
                System.out.println(department + " -> " + employeeList));


        // =====================================================
        // Q099. Find the top two products by sales.
        //
        // IMPORTANT NOTES:
        // 1. Product data should contain a product name and sales value.
        // 2. comparingInt() compares products using their sales.
        // 3. reversed() puts the highest sales first.
        // 4. limit(2) selects the top two products.
        // 5. This question can be solved with the same approach
        //    used to find the highest-paid employees.
        // =====================================================

        // Product is represented here by a Map.Entry:
        // key = product name, value = sales.

        Map<String, Integer> productSales = new java.util.LinkedHashMap<>();
        productSales.put("Laptop", 500);
        productSales.put("Mobile", 900);
        productSales.put("Tablet", 300);
        productSales.put("Monitor", 700);
        productSales.put("Keyboard", 200);

        List<Map.Entry<String, Integer>> topTwoProducts =
                productSales.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue()
                                .reversed())
                        .limit(2)
                        .collect(Collectors.toList());

        System.out.println("\nQ099. Top two products by sales: "
                + topTwoProducts);


        // =====================================================
        // Q100. Explain why sorting before limiting matters.
        //
        // IMPORTANT NOTES:
        // 1. sorted().limit(3) sorts all input values before selecting
        //    the top three values.
        // 2. limit(3).sorted() selects only the first three input values
        //    and then sorts those three values.
        // 3. Therefore, limit(3).sorted() does not generally find
        //    the top three values from the complete input.
        // 4. The order of Stream operations can change the result.
        // 5. For very large datasets, sorting every element may be
        //    more expensive than using a dedicated top-N algorithm.
        // =====================================================

        List<Integer> correctTopThree = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        List<Integer> limitBeforeSorting = numbers.stream()
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("\nQ100. Sorting before limiting:");

        System.out.println("Correct - sorted() then limit(): "
                + correctTopThree);

        System.out.println("Different result - limit() then sorted(): "
                + limitBeforeSorting);
    }
}
