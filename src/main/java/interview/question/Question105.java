package interview.question;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question105 {

    public static void main(String[] args) {

        // Question 105: Find duplicate numbers in an array.
        // IMPORTANT:
        // distinct() removes duplicates, so it cannot identify them alone.
        // groupingBy() counts each number's occurrences.
        // Keep numbers whose frequency is greater than one.

        System.out.println("\nQuestion 105: Find duplicate numbers in an array");

        int[] duplicateNumbers = {10, 20, 30, 20, 40, 10, 50, 30, 30};

        Map<Integer, Long> frequencyMap =
                Arrays.stream(duplicateNumbers)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()
                        ));

        frequencyMap.forEach((number, frequency) -> {
            if (frequency > 1) {
                System.out.println("Duplicate number: " + number + " (" + frequency + " times)");
            }
        });
    }
}
