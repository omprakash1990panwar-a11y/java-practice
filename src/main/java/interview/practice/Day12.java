package interview.practice;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Collectors;

public class Day12 {

    public static void main(String[] args) {

        // Question 111: Create a stream using Stream.of().
        // IMPORTANT:
        // Stream.of() creates a stream from the supplied values.
        // It is commonly used for a small number of known elements.

        System.out.println("Question 111: Create a stream using Stream.of()");

        Stream<String> names = Stream.of("Amit", "Rahul", "Priya", "Neha");

        names.forEach(System.out::println);


        // Question 112: Create an empty stream using Stream.empty().
        // IMPORTANT:
        // Stream.empty() creates a stream containing zero elements.
        // It is useful when a method needs to return a Stream but has no data.

        System.out.println("\nQuestion 112: Create an empty stream");

        Stream<String> emptyStream = Stream.empty();

        System.out.println("Element count: " + emptyStream.count());


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


        // Question 114: Generate values using Stream.generate().
        // IMPORTANT:
        // generate() uses a Supplier to produce values.
        // It creates an infinite stream unless a limiting operation is used.
        // limit(5) restricts the stream to five elements.

        System.out.println("\nQuestion 114: Generate values using Stream.generate()");

        Stream<String> repeatedValues = Stream.generate(() -> "Java")
                .limit(5);

        repeatedValues.forEach(System.out::println);


        // Question 115: Generate a sequence using Stream.iterate().
        // IMPORTANT:
        // iterate(seed, function) starts with a seed value and repeatedly
        // applies a function to generate the next value.
        // In Java 8, the two-argument iterate() creates an infinite stream.

        System.out.println("\nQuestion 115: Generate a sequence using Stream.iterate()");

        Stream<Integer> sequence = Stream.iterate(1, number -> number + 1)
                .limit(10);

        sequence.forEach(System.out::println);


        // Question 116: Create integer ranges using IntStream.range().
        // IMPORTANT:
        // range(start, end) includes the start but excludes the end.
        // It is useful for generating consecutive integers.

        System.out.println("\nQuestion 116: Create integer ranges using range()");

        IntStream.range(1, 6)
                .forEach(System.out::println);


        // Question 117: Create inclusive ranges using rangeClosed().
        // IMPORTANT:
        // rangeClosed(start, end) includes both the start and end values.
        // Compare it with range(), which excludes the ending value.

        System.out.println("\nQuestion 117: Create inclusive ranges using rangeClosed()");

        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);


        // Question 118: Convert an IntStream into a boxed stream.
        // IMPORTANT:
        // IntStream contains primitive int values.
        // boxed() converts them into Integer objects.
        // This allows collecting the values into List<Integer>.

        System.out.println("\nQuestion 118: Convert IntStream into a boxed stream");

        List<Integer> numbers = IntStream.rangeClosed(1, 5)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Integer list: " + numbers);


        // Question 119: Convert IntStream to LongStream and DoubleStream.
        // IMPORTANT:
        // asLongStream() converts int values to long values.
        // asDoubleStream() converts int values to double values.
        // These remain primitive streams; they do not box the values.

        System.out.println("\nQuestion 119: Convert IntStream to LongStream and DoubleStream");

        LongStream longStream = IntStream.rangeClosed(1, 5)
                .asLongStream();

        System.out.print("LongStream: ");
        longStream.forEach(number -> System.out.print(number + "L "));

        System.out.println();

        DoubleStream doubleStream = IntStream.rangeClosed(1, 5)
                .asDoubleStream();

        System.out.print("DoubleStream: ");
        doubleStream.forEach(number -> System.out.print(number + " "));

        System.out.println();


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