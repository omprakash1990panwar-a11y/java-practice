package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question023 {
    public static void main(String[] args) {
        List<Integer> converted = Arrays.asList(100, 200, 300, 400);

        // Question 023: Calculate a total using a lambda expression.
        // Long.valueOf() is unboxed to primitive long by mapToLong().
        long total = converted.stream()
                .mapToLong(value -> Long.valueOf(value))
                .sum();

        System.out.println("Q023 - Total using lambda: " + total);
    }
}
