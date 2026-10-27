package interview.question;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Question106 {

    public static void main(String[] args) {

        // Question 106: Find missing numbers in a range.
        // IMPORTANT:
        // IntStream.rangeClosed(start, end) includes both endpoints.
        // contains() checks whether each number exists in the original array.
        // This approach is easy to understand but can be slow for large arrays.

        System.out.println("\nQuestion 106: Find missing numbers in a range");

        int[] rangeNumbers = {1, 2, 4, 6, 8, 10};

        int start = 1;
        int end = 10;

        int[] missingNumbers = IntStream.rangeClosed(start, end)
                .filter(number ->
                        Arrays.stream(rangeNumbers)
                                .noneMatch(value -> value == number))
                .toArray();

        System.out.println("Missing numbers: " + Arrays.toString(missingNumbers));
    }
}
