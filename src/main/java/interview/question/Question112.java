package interview.question;

import java.util.stream.Stream;

public class Question112 {

    public static void main(String[] args) {

        // Question 112: Create an empty stream using Stream.empty().
        // IMPORTANT:
        // Stream.empty() creates a stream containing zero elements.
        // It is useful when a method needs to return a Stream but has no data.

        System.out.println("\nQuestion 112: Create an empty stream");

        Stream<String> emptyStream = Stream.empty();

        System.out.println("Element count: " + emptyStream.count());
    }
}
