package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question179 {
    public static void main(String[] args) {
        // =========================================================
        // Question 179: Explain stream reuse and IllegalStateException.
        // Concept: a stream cannot be operated on more than once.
        // Create a new stream for each independent pipeline.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> reusedStream = numbers.stream();

        long firstCount = reusedStream.count();

        System.out.println("Q179 - First stream count: " + firstCount);

        try {
            // This throws IllegalStateException because the stream was consumed.
            reusedStream.forEach(System.out::println);
        } catch (IllegalStateException exception) {
            System.out.println(
                    "Q179 - Exception: stream has already been operated upon or closed."
            );
        }

        // Correct approach: create a fresh stream.
        long freshStreamCount = numbers.stream().count();

        System.out.println("Q179 - Count using a fresh stream: " + freshStreamCount);
    }
}
