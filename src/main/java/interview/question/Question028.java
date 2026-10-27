package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question028 {

    public static void main(String[] args) {

        // Find the smallest three distinct numbers.
        List<Integer> numbers = Arrays.asList(
                40, 10, 30, 20, 50, 20, 60, 10, 70
        );

        List<Integer> smallestThree = numbers.stream()
                .distinct()
                .sorted()
                .limit(3)
                .toList();

        System.out.println(
                "Q028 - Smallest three distinct numbers: "
                        + smallestThree);
    }
}