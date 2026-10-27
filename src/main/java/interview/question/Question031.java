package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question031 {
    public static void main(String[] args) {
        // Flatten a List of Lists into one List.
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> result = nestedList.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Q31 - Flattened nested list: " + result);
    }
}
