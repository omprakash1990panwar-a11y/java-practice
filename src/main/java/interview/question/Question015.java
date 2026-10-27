package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question015 {
    public static void main(String[] args) {
        List<String> numericStrings = Arrays.asList("100", "200", "300", "400");

        // Question 015: Convert numeric strings into integers.
        // Integer.parseInt() parses each numeric string.
        List<Integer> converted = numericStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Q015 - Parsed integers: " + converted);

        // Alternative: use a lambda instead of a method reference.
        List<Integer> converted2 = numericStrings.stream()
                .map(value -> Integer.parseInt(value))
                .collect(Collectors.toList());

        System.out.println("Q015 - Parsed using lambda: " + converted2);
    }
}
