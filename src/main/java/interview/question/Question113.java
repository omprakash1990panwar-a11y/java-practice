package interview.question;

import java.util.stream.Stream;

public class Question113 {

    public static void main(String[] args) {

        // Question 113: Create a stream using Stream.builder().
        // IMPORTANT:
        // Stream.builder() allows elements to be added incrementally.
        // build() creates the stream after all elements have been added.
        // Do not add more elements after build().

        System.out.println("\nQuestion 113: Create a stream using Stream.builder()");

        Stream.Builder<String> builder = Stream.builder();

        builder.add("Java");
        builder.add("Spring Boot");
        builder.add("Microservices");

        Stream<String> technologyStream = builder.build();

        technologyStream.forEach(System.out::println);
    }
}
