package interview.question;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question141 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 141: Reverse a string using streams
        // Important: IntStream.range() generates character indexes.
        // Collect characters in reverse index order.
        // --------------------------------------------------

        System.out.println("Question 141:");

        String text = "Java";

        String reversed = IntStream.range(0, text.length())
                .mapToObj(i -> text.charAt(text.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reversed);
    }
}
