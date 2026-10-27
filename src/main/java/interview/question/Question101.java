package interview.question;

import java.util.Arrays;
import java.util.stream.Stream;

public class Question101 {

    public static void main(String[] args) {

        // Question 101: Convert an array into a stream.
        // IMPORTANT:
        // Arrays.stream() converts an object array into a Stream.
        // Stream operations allow filtering, mapping, and collecting.

        System.out.println("Question 101: Convert an array into a stream");

        String[] names = {"Amit", "Rahul", "Priya", "Neha"};

        Stream<String> nameStream = Arrays.stream(names);

        nameStream.forEach(System.out::println);
    }
}
