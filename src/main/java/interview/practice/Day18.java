
package interview.practice;

import interview.UtilPackages.Employee;
import interview.UtilPackages.Worker;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day18 {

    public static void main(String[] args) {

        /*
         * IMPORTANT NOTES:
         *
         * 1. Intermediate operations are lazy; a terminal operation triggers execution.
         * 2. Parallel streams may execute tasks on different threads.
         * 3. Never assume parallel execution order unless explicitly preserved.
         * 4. Use collect(), reduce(), or other proper aggregation operations
         *    instead of modifying shared mutable variables.
         * 5. This class uses the existing Employee and Worker utility classes.
         */

        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", 80000, "amit@example.com"),
                new Employee("Priya", "IT", 60000, "priya@example.com"),
                new Employee("Rahul", "IT", 90000, "rahul@example.com"),
                new Employee("Neha", "HR", 75000, "neha@example.com"),
                new Employee("Karan", "HR", 50000, "karan@example.com")
        );

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);


        // =========================================================
        // Question 171: Compare stream() and parallelStream().
        // Concept: stream() processes sequentially by default;
        // parallelStream() enables parallel processing.
        // =========================================================

        double sequentialSalaryTotal = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double parallelSalaryTotal = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Q171 - Sequential salary total: "
                + sequentialSalaryTotal);

        System.out.println("Q171 - Parallel salary total: "
                + parallelSalaryTotal);


        // =========================================================
        // Question 172: Convert a stream to parallel using parallel().
        // Concept: parallel() switches the stream pipeline to parallel mode.
        // =========================================================

        int parallelSum = numbers.stream()
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q172 - Sum using parallel(): " + parallelSum);


        // =========================================================
        // Question 173: Convert a parallel stream to sequential.
        // Concept: sequential() switches the pipeline back to sequential mode.
        // =========================================================

        int sequentialSumAgain = numbers.parallelStream()
                .sequential()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q173 - Sum after sequential(): "
                + sequentialSumAgain);


        // =========================================================
        // Question 174: Explain forEach() versus forEachOrdered().
        // Concept: forEach() does not guarantee encounter order on a
        // parallel stream. forEachOrdered() preserves encounter order.
        // =========================================================

        System.out.println("Q174 - Parallel forEach():");

        numbers.parallelStream()
                .forEach(number ->
                        System.out.print(number + " "));

        System.out.println();

        System.out.println("Q174 - Parallel forEachOrdered():");

        numbers.parallelStream()
                .forEachOrdered(number ->
                        System.out.print(number + " "));

        System.out.println();


        // =========================================================
        // Question 175: Explain encounter order and unordered().
        // Concept: encounter order is the order defined by the source.
        // unordered() removes the requirement to preserve that order.
        // It does not necessarily shuffle the elements.
        // =========================================================

        System.out.println("Q175 - Original encounter order:");

        numbers.stream()
                .forEach(number ->
                        System.out.print(number + " "));

        System.out.println();

        System.out.println("Q175 - Parallel unordered() traversal:");

        numbers.parallelStream()
                .unordered()
                .forEach(number ->
                        System.out.print(number + " "));

        System.out.println();


        // =========================================================
        // Question 176: Inspect elements with peek() for debugging.
        // Concept: peek() lets you inspect elements as they pass through
        // the pipeline. It runs when a terminal operation consumes them.
        // =========================================================

        List<Integer> doubledNumbers = numbers.stream()
                .peek(number ->
                        System.out.println("Q176 - Before map: " + number))
                .map(number -> number * 2)
                .peek(number ->
                        System.out.println("Q176 - After map: " + number))
                .collect(Collectors.toList());

        System.out.println("Q176 - Final list: " + doubledNumbers);


        // =========================================================
        // Question 177: Explain lazy intermediate operations.
        // Concept: filter() and map() do not run until a terminal
        // operation is invoked. limit() can short-circuit processing.
        // =========================================================

        System.out.println("Q177 - Creating stream pipeline:");

        List<Integer> lazyResult = numbers.stream()
                .filter(number -> {
                    System.out.println("Q177 - Filtering: " + number);
                    return number > 2;
                })
                .map(number -> {
                    System.out.println("Q177 - Mapping: " + number);
                    return number * 10;
                })
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Q177 - Result: " + lazyResult);


        // =========================================================
        // Question 178: Explain stateless versus stateful operations.
        // Concept: filter() and map() are stateless intermediate
        // operations. sorted() and distinct() are stateful operations.
        // =========================================================

        List<Integer> unsortedNumbers =
                Arrays.asList(5, 2, 3, 2, 1, 5, 4);

        List<Integer> statelessResult = unsortedNumbers.stream()
                .filter(number -> number > 2)
                .map(number -> number * 10)
                .collect(Collectors.toList());

        List<Integer> statefulResult = unsortedNumbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Q178 - Stateless operations result: "
                + statelessResult);

        System.out.println("Q178 - Stateful operations result: "
                + statefulResult);


        // =========================================================
        // Question 179: Explain stream reuse and IllegalStateException.
        // Concept: a stream cannot be operated on more than once.
        // Create a new stream for each independent pipeline.
        // =========================================================

        java.util.stream.Stream<Integer> reusedStream = numbers.stream();

        long firstCount = reusedStream.count();

        System.out.println("Q179 - First stream count: " + firstCount);

        try {
            // This throws IllegalStateException because the stream was consumed.
            reusedStream.forEach(System.out::println);
        } catch (IllegalStateException exception) {
            System.out.println(
                    "Q179 - Exception: stream has already been operated upon or closed."
            );
        }

        // Correct approach: create a fresh stream.
        long freshStreamCount = numbers.stream().count();

        System.out.println("Q179 - Count using a fresh stream: "
                + freshStreamCount);


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

        List<Worker> workers = Arrays.asList(
                new Worker("Amit", "IT", 80000),
                new Worker("Priya", "HR", 60000),
                new Worker("Rahul", "IT", 90000),
                new Worker("Neha", "Finance", 70000)
        );

        List<String> workerNames = workers.parallelStream()
                .map(Worker::getName)
                .collect(Collectors.toList());

        int totalWorkerSalary = workers.parallelStream()
                .mapToInt(Worker::getSalary)
                .sum();

        System.out.println("Q180 - Worker names (safe collection): "
                + workerNames);

        System.out.println("Q180 - Total worker salary (safe sum): "
                + totalWorkerSalary);
    }
}
