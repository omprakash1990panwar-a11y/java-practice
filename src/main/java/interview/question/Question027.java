package interview.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question027 {

    public static void main(String[] args) {

        // Find the third-highest distinct number.
        List<Integer> numbers = Arrays.asList(
                40, 10, 30, 20, 50, 20, 60, 10, 70
        );

        Integer thirdHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Not enough distinct numbers"));

        System.out.println(
                "Q027 - Third-highest distinct number: "
                        + thirdHighest);
    }
}