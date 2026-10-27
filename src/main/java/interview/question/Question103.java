package interview.question;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Question103 {

    public static void main(String[] args) {

        // Question 103: Find the sum of an array using streams.
        // IMPORTANT:
        // IntStream.sum() returns the sum of all integer elements.
        // It avoids manually maintaining a sum variable.

        System.out.println("\nQuestion 103: Find the sum of an array");

        int[] sumNumbers = {10, 20, 30, 40, 50};

        int sum = Arrays.stream(sumNumbers).sum();

        System.out.println("Sum: " + sum);
    }
}
