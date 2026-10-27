package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question021 {
    public static void main(String[] args) {
        List<String> numericStrings = Arrays.asList("100", "200", "300", "400");

        // Question 021: Convert numeric strings to doubles and calculate their sum.
        // mapToDouble() parses each string as a primitive double.
        double doubleSum = numericStrings.stream()
                .mapToDouble(Double::parseDouble)
                .sum();

        System.out.println("Q021 - Numeric string sum: " + doubleSum);
    }
}
