package interview.question;

import java.util.stream.IntStream;

public class Question116 {

    public static void main(String[] args) {

        // Question 116: Create integer ranges using IntStream.range().
        // IMPORTANT:
        // range(start, end) includes the start but excludes the end.
        // It is useful for generating consecutive integers.

        System.out.println("\nQuestion 116: Create integer ranges using range()");

        IntStream.range(1, 6)
                .forEach(System.out::println);
    }
}
