package interview.question;

import java.util.stream.Stream;

public class Question115 {

    public static void main(String[] args) {

        // Question 115: Generate a sequence using Stream.iterate().
        // IMPORTANT:
        // iterate(seed, function) starts with a seed value and repeatedly
        // applies a function to generate the next value.
        // In Java 8, the two-argument iterate() creates an infinite stream.

        System.out.println("\nQuestion 115: Generate a sequence using Stream.iterate()");

        Stream<Integer> sequence = Stream.iterate(1, number -> number + 1)
                .limit(10);

        sequence.forEach(System.out::println);
    }
}
