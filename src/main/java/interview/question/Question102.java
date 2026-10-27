package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question102 {

    public static void main(String[] args) {

        // Question 102: Convert an integer array into a list.
        // IMPORTANT:
        // Arrays.stream(int[]) creates an IntStream.
        // boxed() converts primitive int values into Integer objects.
        // collect() gathers the elements into a List<Integer>.

        System.out.println("\nQuestion 102: Convert an integer array into a list");

        int[] numbers = {10, 20, 30, 40, 50};

        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numberList);
    }
}
