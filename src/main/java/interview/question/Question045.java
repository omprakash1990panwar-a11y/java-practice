package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question045 {
    public static void main(String[] args) {
        // =====================================================
        // Question 045: Concatenate strings using reduce()
        // reduce("", (a, b) -> a + b) combines strings without separators.
        // Collectors.joining(" ") joins strings with a space between them.
        // =====================================================

        List<String> words = Arrays.asList("Java", "Spring", "Boot");

        // Approach 1: Using parallelStream() and reduce().
        String concatenated = words.parallelStream()
                .reduce("", (a, b) -> a + b);

        System.out.println("Q45 - Concatenation using reduce(): "
                + concatenated);

        // Approach 2: Using Collectors.joining().
        String concatenated2 = words.stream().collect(Collectors.joining(" "));

        System.out.println("Q45 - Concatenation using joining(): "
                + concatenated2);
    }
}
