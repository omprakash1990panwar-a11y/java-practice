package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question137 {

    // --------------------------------------------------
    // Question 137: Find maximum and handle an empty stream
    // Important: max() returns Optional<T> because the stream may be empty.
    // --------------------------------------------------

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        List<Integer> numbers = Arrays.asList(10, 30, 20, 50, 40);

        // Use max()
        // Important: max() applies a comparator to the values inside the Optional.
        Optional<Integer> maximum =
                numbers.stream().max(Integer::compareTo);

        System.out.println("Maximum: " + maximum.orElse(-1));

        List<Integer> emptyNumbers = Arrays.asList();

        Optional<Integer> emptyMaximum =
                emptyNumbers.stream().max(Integer::compareTo);

        System.out.println("Maximum of empty list: " +
                emptyMaximum.orElse(-1));
    }

}
