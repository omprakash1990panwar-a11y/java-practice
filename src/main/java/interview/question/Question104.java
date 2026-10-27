package interview.question;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Question104 {

    public static void main(String[] args) {

        // Question 104: Find the average of an array.
        // IMPORTANT:
        // IntStream.average() returns an OptionalDouble.
        // An empty array has no average, so check whether a value exists.

        System.out.println("\nQuestion 104: Find the average of an array");

        int[] averageNumbers = {10, 20, 30, 40, 50};

        OptionalDouble average = Arrays.stream(averageNumbers).average();

        if (average.isPresent()) {
            System.out.println("Average: " + average.getAsDouble());
        } else {
            System.out.println("Average: Not found");
        }
    }
}
