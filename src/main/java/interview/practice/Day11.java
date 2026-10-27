package interview.practice;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.IntSummaryStatistics;

public class Day11 {

    public static void main(String[] args) {

        // Question 101: Convert an array into a stream.
        // IMPORTANT:
        // Arrays.stream() converts an object array into a Stream.
        // Stream operations allow filtering, mapping, and collecting.

        System.out.println("Question 101: Convert an array into a stream");

        String[] names = {"Amit", "Rahul", "Priya", "Neha"};

        Stream<String> nameStream = Arrays.stream(names);

        nameStream.forEach(System.out::println);


        // Question 102: Convert an integer array into a list.
        // IMPORTANT:
        // Arrays.stream(int[]) creates an IntStream.
        // boxed() converts primitive int values into Integer objects.
        // collect() gathers the elements into a List<Integer>.

        System.out.println("\nQuestion 102: Convert an integer array into a list");

        int[] numbers = {10, 20, 30, 40, 50};

        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numberList);


        // Question 103: Find the sum of an array using streams.
        // IMPORTANT:
        // IntStream.sum() returns the sum of all integer elements.
        // It avoids manually maintaining a sum variable.

        System.out.println("\nQuestion 103: Find the sum of an array");

        int[] sumNumbers = {10, 20, 30, 40, 50};

        int sum = Arrays.stream(sumNumbers).sum();

        System.out.println("Sum: " + sum);


        // Question 104: Find the average of an array.
        // IMPORTANT:
        // IntStream.average() returns an OptionalDouble.
        // An empty array has no average, so check whether a value exists.

        System.out.println("\nQuestion 104: Find the average of an array");

        int[] averageNumbers = {10, 20, 30, 40, 50};

        double average = Arrays.stream(averageNumbers)
                .average()
                .orElse(0.0);

        System.out.println("Average: " + average);


        // Question 105: Find duplicate numbers in an array.
        // IMPORTANT:
        // distinct() removes duplicates, so it cannot identify them alone.
        // groupingBy() counts each number's occurrences.
        // Keep numbers whose frequency is greater than one.

        System.out.println("\nQuestion 105: Find duplicate numbers in an array");

        int[] duplicateNumbers = {10, 20, 30, 20, 40, 10, 50, 30, 30};

        Map<Integer, Long> frequencyMap =
                Arrays.stream(duplicateNumbers)
                        .boxed()
                        .collect(Collectors.groupingBy(
                                number -> number,
                                Collectors.counting()
                        ));

        List<Integer> duplicates = frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Duplicates: " + duplicates);


        // Question 106: Find missing numbers in a range.
        // IMPORTANT:
        // IntStream.rangeClosed(start, end) includes both endpoints.
        // contains() checks whether each number exists in the original array.
        // This approach is easy to understand but can be slow for large arrays.

        System.out.println("\nQuestion 106: Find missing numbers in a range");

        int[] rangeNumbers = {1, 2, 4, 6, 8, 10};

        int start = 1;
        int end = 10;

        List<Integer> missingNumbers =
                IntStream.rangeClosed(start, end)
                        .filter(number ->
                                Arrays.stream(rangeNumbers)
                                        .noneMatch(value -> value == number))
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println("Missing numbers: " + missingNumbers);


        // Question 107: Find common elements in two arrays.
        // IMPORTANT:
        // filter() retains elements satisfying a condition.
        // anyMatch() checks whether an element exists in the second array.
        // distinct() prevents repeated common elements in the result.

        System.out.println("\nQuestion 107: Find common elements in two arrays");

        int[] firstArray = {10, 20, 30, 40, 50, 20};
        int[] secondArray = {30, 40, 50, 60, 70};

        List<Integer> commonElements =
                Arrays.stream(firstArray)
                        .filter(number ->
                                Arrays.stream(secondArray)
                                        .anyMatch(value -> value == number))
                        .distinct()
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println("Common elements: " + commonElements);


        // Question 108: Find the intersection of two lists.
        // IMPORTANT:
        // Intersection means elements present in both lists.
        // distinct() returns each common value only once.
        // This example preserves the order of firstList.

        System.out.println("\nQuestion 108: Find the intersection of two lists");

        List<Integer> firstList =
                Arrays.asList(10, 20, 30, 40, 50, 20);

        List<Integer> secondList =
                Arrays.asList(30, 40, 50, 60, 70);

        List<Integer> intersection =
                firstList.stream()
                        .filter(secondList::contains)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("Intersection: " + intersection);


        // Question 109: Find the union of two lists.
        // IMPORTANT:
        // Union combines elements from both lists without duplicates.
        // LinkedHashSet preserves insertion order.
        // Stream.concat() combines the two streams.

        System.out.println("\nQuestion 109: Find the union of two lists");

        List<Integer> unionFirstList =
                Arrays.asList(10, 20, 30, 40);

        List<Integer> unionSecondList =
                Arrays.asList(30, 40, 50, 60);

        List<Integer> union =
                Stream.concat(
                                unionFirstList.stream(),
                                unionSecondList.stream()
                        )
                        .collect(Collectors.toCollection(LinkedHashSet::new))
                        .stream()
                        .collect(Collectors.toList());

        System.out.println("Union: " + union);


        // Question 110: Calculate IntSummaryStatistics for an array.
        // IMPORTANT:
        // summaryStatistics() calculates count, sum, min, max, and average.
        // It is useful when multiple numeric statistics are required.
        // For an empty stream, count and sum are zero, while min and max
        // are represented by their primitive type's extreme values.

        System.out.println("\nQuestion 110: Calculate IntSummaryStatistics");

        int[] statisticsNumbers = {10, 20, 30, 40, 50};

        IntSummaryStatistics statistics =
                Arrays.stream(statisticsNumbers)
                        .summaryStatistics();

        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Minimum: " + statistics.getMin());
        System.out.println("Maximum: " + statistics.getMax());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Complete statistics: " + statistics);
    }
}