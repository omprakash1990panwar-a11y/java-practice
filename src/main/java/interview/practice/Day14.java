package interview.practice;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day14 {

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", "Developer", 60000),
                new Employee("Priya", "IT", "Tester", 50000),
                new Employee("Rahul", "IT", "Developer", 70000),
                new Employee("Neha", "HR", "Manager", 55000),
                new Employee("Karan", "HR", "Recruiter", 45000)
        );

        // --------------------------------------------------
        // Question 131: Use Optional.ofNullable() safely
        // Important: ofNullable() accepts both null and non-null values.
        // Unlike Optional.of(), it does not throw NPE for a null argument.
        // --------------------------------------------------

        System.out.println("Question 131:");

        String name = null;

        Optional<String> optionalName = Optional.ofNullable(name);

        System.out.println("Is name present? " + optionalName.isPresent());
        System.out.println("Name: " +
                optionalName.orElse("Unknown"));


        // --------------------------------------------------
        // Question 132: Use orElse() and orElseGet()
        // Important: orElse() evaluates its fallback eagerly.
        // orElseGet() calls its Supplier only when the Optional is empty.
        // --------------------------------------------------

        System.out.println("\nQuestion 132:");

        Optional<String> existingName = Optional.of("Amit");

        String result1 = existingName.orElse(getDefaultName());
        String result2 = existingName.orElseGet(() -> getDefaultName());

        System.out.println("orElse result: " + result1);
        System.out.println("orElseGet result: " + result2);


        // --------------------------------------------------
        // Question 133: Use orElseThrow() when a value is absent
        // Important: Java 8 uses orElseThrow(Supplier).
        // It throws the supplied exception when the Optional is empty.
        // --------------------------------------------------

        System.out.println("\nQuestion 133:");

        Optional<String> emptyName = Optional.empty();

        try {
            String value = emptyName.orElseThrow(
                    () -> new IllegalArgumentException("Name is missing")
            );

            System.out.println(value);

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }


        // --------------------------------------------------
        // Question 134: Filter an Optional value
        // Important: filter() keeps the value only when the condition is true.
        // Otherwise, it returns an empty Optional.
        // --------------------------------------------------

        System.out.println("\nQuestion 134:");

        Optional<Integer> salary = Optional.of(60000);

        Optional<Integer> filteredSalary =
                salary.filter(s -> s >= 50000);

        System.out.println("Filtered salary: " +
                filteredSalary.orElse(0));


        // --------------------------------------------------
        // Question 135: Transform an Optional using map()
        // Important: map() transforms a present value into another value.
        // If the mapper returns null, the resulting Optional is empty.
        // --------------------------------------------------

        System.out.println("\nQuestion 135:");

        Optional<String> employeeName = Optional.of("Amit");

        Optional<String> upperCaseName =
                employeeName.map(String::toUpperCase);

        System.out.println("Uppercase name: " +
                upperCaseName.orElse("Unknown"));


        // --------------------------------------------------
        // Question 136: Chain Optional values using flatMap()
        // Important: flatMap() avoids Optional<Optional<T>> nesting.
        // Use it when the mapping function itself returns an Optional.
        // --------------------------------------------------

        System.out.println("\nQuestion 136:");

        Optional<Employee> optionalEmployee =
                Optional.of(employees.get(0));

        Optional<String> department =
                optionalEmployee.flatMap(
                        emp -> Optional.ofNullable(emp.getDepartment())
                );

        System.out.println("Department: " +
                department.orElse("Department not available"));


        // --------------------------------------------------
        // Question 137: Find maximum and handle an empty stream
        // Important: max() returns Optional<T> because the stream may be empty.
        // --------------------------------------------------

        System.out.println("\nQuestion 137:");

        List<Integer> numbers = Arrays.asList(10, 30, 20, 50, 40);

        Optional<Integer> maximum =
                numbers.stream().max(Integer::compareTo);

        System.out.println("Maximum: " + maximum.orElse(-1));

        List<Integer> emptyNumbers = Arrays.asList();

        Optional<Integer> emptyMaximum =
                emptyNumbers.stream().max(Integer::compareTo);

        System.out.println("Maximum of empty list: " +
                emptyMaximum.orElse(-1));


        // --------------------------------------------------
        // Question 138: Safely extract a nullable employee department
        // Important: ofNullable() protects against a null department.
        // --------------------------------------------------

        System.out.println("\nQuestion 138:");

        Employee employeeWithDepartment = employees.get(0);

        String safeDepartment = Optional.ofNullable(
                        employeeWithDepartment.getDepartment()
                )
                .orElse("Unknown Department");

        System.out.println("Department: " + safeDepartment);


        // --------------------------------------------------
        // Question 139: Avoid NullPointerException when processing names
        // Important: filter out null names before calling methods on them.
        // Optional.ofNullable() safely wraps a possibly null value.
        // --------------------------------------------------

        System.out.println("\nQuestion 139:");

        List<String> names = Arrays.asList(
                "amit", null, "priya", "rahul", null
        );

        List<String> safeNames = names.stream()
                .filter(n -> n != null)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Safe names: " + safeNames);

        Optional<String> nullableName = Optional.ofNullable(null);

        System.out.println("Nullable name: " +
                nullableName.orElse("Name not available"));


        // --------------------------------------------------
        // Question 140: Explain why Optional.get() should not be used blindly
        // Important: get() throws NoSuchElementException when Optional is empty.
        // Prefer orElse(), orElseGet(), orElseThrow(), or ifPresent().
        // --------------------------------------------------

        System.out.println("\nQuestion 140:");

        Optional<String> presentValue = Optional.of("Java");

        System.out.println("Present value: " + presentValue.get());

        Optional<String> missingValue = Optional.empty();

        // Unsafe approach:
        // missingValue.get(); // Throws NoSuchElementException

        // Safe approach:
        System.out.println("Missing value: " +
                missingValue.orElse("Default Value"));
    }

    private static String getDefaultName() {
        System.out.println("Default value method executed");
        return "Guest";
    }
}