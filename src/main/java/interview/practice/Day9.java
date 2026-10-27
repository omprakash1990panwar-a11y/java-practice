package interview.practice;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Day9 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<String> strings =Arrays.asList("Java", "Streams", "", "Spring");

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering",
                        90000, "alice@example.com"),
                new Employee("Bob", "HR",
                        60000, "bob@example.com"),
                new Employee("Charlie", "Engineering",
                        75000, "charlie@example.com"),
                new Employee("Diana", "Finance",
                        50000, "diana@example.com"),
                new Employee("Ethan", null,
                        65000, null)
        );

        // =====================================================
        // Q081. allMatch() - Check whether all numbers are positive
        //
        // IMPORTANT NOTES:
        // 1. allMatch() returns true only if every element matches.
        // 2. It returns false as soon as one element fails.
        // 3. It is a short-circuiting terminal operation.
        // 4. For an empty stream, allMatch() returns true.
        // =====================================================

        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("Q081. All numbers are positive: "+ allPositive);


        // =====================================================
        // Q082. noneMatch() - Check whether no string is empty
        //
        // IMPORTANT NOTES:
        // 1. noneMatch() returns true if no element matches.
        // 2. It returns false as soon as a matching element is found.
        // 3. For an empty stream, noneMatch() returns true.
        // 4. This predicate assumes strings are not null.
        // =====================================================

        boolean noEmptyStrings = strings.stream()
                .noneMatch(s -> s.isEmpty());

        System.out.println("Q082. No strings are empty: "
                + noEmptyStrings);


        // =====================================================
        // Q083. filter() + findFirst()
        // Find the first employee earning above 70000.
        //
        // IMPORTANT NOTES:
        // 1. filter() is an intermediate operation.
        // 2. findFirst() is a short-circuiting terminal operation.
        // 3. findFirst() respects encounter order when defined.
        // 4. It returns Optional<Employee>, not Employee directly.
        // 5. Optional helps represent a result that may be absent.
        // =====================================================

        Optional<Employee> firstEmployee = employees.stream()
                .filter(e -> e.getSalary() > 70000)
                .findFirst();

        System.out.println("Q083. First employee earning above 70000: "
                + firstEmployee.orElse(null));


        // =====================================================
        // Q084. filter() + findAny()
        // Find any employee in Engineering.
        //
        // IMPORTANT NOTES:
        // 1. findAny() can return any matching element.
        // 2. It does not guarantee the first matching element.
        // 3. It is useful when encounter order is not important.
        // 4. It can offer more flexibility with parallel streams.
        // 5. "Engineering".equals(...) safely handles a null department.
        // =====================================================

        Optional<Employee> anyEmployee = employees.stream()
                .filter(e -> "Engineering".equals(e.getDepartment()))
                .findAny();

        System.out.println("Q084. Any employee in Engineering: "
                + anyEmployee.orElse(null));


        // =====================================================
        // Q085. Find the first non-empty string.
        //
        // IMPORTANT NOTES:
        // 1. filter() removes strings that do not satisfy the condition.
        // 2. findFirst() returns the first remaining element.
        // 3. orElse() provides a fallback when Optional is empty.
        // 4. This predicate assumes strings are not null.
        // =====================================================

        Optional<String> firstNonEmpty = strings.stream()
                .filter(s -> !s.isEmpty())
                .findFirst();

        System.out.println("Q085. First non-empty string: "
                + firstNonEmpty.orElse("Not found"));


        // =====================================================
        // Q086. anyMatch() - Check whether a list contains a target
        //
        // IMPORTANT NOTES:
        // 1. anyMatch() returns true if at least one element matches.
        // 2. It stops processing when a match is found.
        // 3. It returns false if no element matches.
        // 4. For an empty stream, anyMatch() returns false.
        // 5. For a simple list, List.contains() is another option.
        // =====================================================

        int target = 3;

        boolean containsTarget = numbers.stream()
                .anyMatch(n -> n == target);

        System.out.println("Q086. List contains target " + target
                + ": " + containsTarget);


        // =====================================================
        // Q087. allMatch() - Validate employee salary threshold
        //
        // IMPORTANT NOTES:
        // 1. allMatch() is useful for validating business rules.
        // 2. Here, every employee must earn at least 50000.
        // 3. The result is false if even one employee fails.
        // 4. An empty stream returns true (vacuous truth).
        // =====================================================

        boolean salaryValid = employees.stream()
                .allMatch(e -> e.getSalary() >= 50000);

        System.out.println("Q087. All employees earn at least 50000: "
                + salaryValid);


        // =====================================================
        // Q088. anyMatch() - Check whether any employee has a null field
        //
        // IMPORTANT NOTES:
        // 1. anyMatch() returns true when one employee has a null field.
        // 2. Check each field explicitly when validating objects.
        // 3. A null-safe check is essential when calling methods on fields.
        // 4. This checks the selected fields, not every possible field.
        // =====================================================

        boolean hasNullField = employees.stream()
                .anyMatch(e ->
                        e.getName() == null
                                || e.getDepartment() == null
                                || e.getEmail() == null);

        System.out.println("Q088. Any employee has a null field: "
                + hasNullField);


        // =====================================================
        // Q089. Short-circuiting terminal operation: anyMatch()
        //
        // IMPORTANT NOTES:
        // 1. Short-circuiting means processing can stop early.
        // 2. anyMatch() stops as soon as it finds a match.
        // 3. peek() is used here only to observe processed elements.
        // 4. peek() should not be relied upon for essential side effects.
        // 5. The counter demonstrates processing in this example.
        // =====================================================

        int[] inspected = {0};

        boolean foundTwo = numbers.stream()
                .peek(n -> inspected[0]++)
                .anyMatch(n -> n == 2);

        System.out.println("Q089. Found number 2: " + foundTwo);
        System.out.println("Q089. Numbers inspected: "
                + inspected[0]);


        // =====================================================
        // Q090. Compare findFirst() and findAny()
        //
        // IMPORTANT NOTES:
        // 1. findFirst() returns the first match in encounter order.
        // 2. findAny() may return any matching element.
        // 3. Both return Optional<T>.
        // 4. Both are short-circuiting terminal operations.
        // 5. With a sequential ordered stream, findAny() often returns
        //    the first match, but this is not guaranteed.
        // 6. Do not depend on findAny() for ordered selection.
        // =====================================================

        Optional<Integer> firstNumber = numbers.stream()
                .filter(n -> n > 2)
                .findFirst();

        Optional<Integer> anyNumber = numbers.stream()
                .filter(n -> n > 2)
                .findAny();

        System.out.println("Q090. findFirst() result: "
                + firstNumber.orElse(null));

        System.out.println("Q090. findAny() result: "
                + anyNumber.orElse(null));
    }
}
