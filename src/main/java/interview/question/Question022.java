package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question022 {
    public static void main(String[] args) {
        List<Integer> converted = Arrays.asList(100, 200, 300, 400);

        // Question 022: Calculate a total using mapToLong() and a method reference.
        // Integer::longValue converts each Integer to primitive long.
        long total = converted.stream()
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println("Q022 - Total using method reference: " + total);
    }
}
