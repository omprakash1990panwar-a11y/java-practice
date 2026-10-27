package interview.question;

import java.util.stream.IntStream;

public class Question119 {

    public static void main(String[] args) {

        // Question 119: Convert IntStream to LongStream and DoubleStream.
        // IMPORTANT:
        // asLongStream() converts int values to long values.
        // asDoubleStream() converts int values to double values.
        // These remain primitive streams; they do not box the values.

        System.out.println("\nQuestion 119: Convert IntStream to LongStream and DoubleStream");

        IntStream.rangeClosed(1, 5)
                .asLongStream()
                .forEach(System.out::print);

        System.out.println();

        IntStream.rangeClosed(1, 5)
                .asDoubleStream()
                .forEach(System.out::print);
    }
}
