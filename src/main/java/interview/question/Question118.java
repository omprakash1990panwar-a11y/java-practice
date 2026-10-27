package interview.question;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Question118 {

    public static void main(String[] args) {

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
    }
}
