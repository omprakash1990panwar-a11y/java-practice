package interview.question;

import java.util.stream.Stream;

public class Question114 {

    public static void main(String[] args) {

        // Question 114: Generate values using Stream.generate().
        // IMPORTANT:
        // generate() uses a Supplier to produce values.
        // It creates an infinite stream unless a limiting operation is used.
        // limit(5) restricts the stream to five elements.

        System.out.println("\nQuestion 114: Generate values using Stream.generate()");

        Stream<String> repeatedValues = Stream.generate(() -> "Java")
                .limit(5);

        repeatedValues.forEach(System.out::println);
    }
}
