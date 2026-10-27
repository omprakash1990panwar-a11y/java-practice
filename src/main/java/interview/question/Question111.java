package interview.question;

import java.util.stream.Stream;

public class Question111 {

    public static void main(String[] args) {

        // Question 111: Create a stream using Stream.of().
        // IMPORTANT:
        // Stream.of() creates a stream from the supplied values.
        // It is commonly used for a small number of known elements.

        System.out.println("Question 111: Create a stream using Stream.of()");

        Stream<String> names = Stream.of("Amit", "Rahul", "Priya", "Neha");

        names.forEach(System.out::println);
    }
}
