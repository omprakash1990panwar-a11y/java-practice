package interview.question;

import java.util.stream.IntStream;

public class Question117 {

    public static void main(String[] args) {

        // Question 117: Create inclusive ranges using rangeClosed().
        // IMPORTANT:
        // rangeClosed(start, end) includes both the start and end values.
        // Compare it with range(), which excludes the ending value.

        System.out.println("\nQuestion 117: Create inclusive ranges using rangeClosed()");

        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);
    }
}
