package interview.question;

import java.util.stream.Stream;

public class Question120 {

    public static void main(String[] args) {

        // Question 120: Concatenate two streams using Stream.concat().
        // IMPORTANT:
        // Stream.concat() combines two streams into one stream.
        // The elements from the first stream appear before the second.
        // It does not automatically remove duplicate elements.

        System.out.println("\nQuestion 120: Concatenate two streams using Stream.concat()");

        Stream<String> firstStream = Stream.of("Java", "Spring");
        Stream<String> secondStream = Stream.of("Docker", "Kubernetes");

        Stream<String> combinedStream = Stream.concat(firstStream, secondStream);

        combinedStream.forEach(System.out::println);
    }
}