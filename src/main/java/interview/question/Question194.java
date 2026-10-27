package interview.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question194 {
    public static void main(String[] args) {

        // =========================================================
        // Question 194: Find the Nth-highest distinct number.
        //
        // Concept:
        // distinct() removes duplicates, reverse sorting puts the
        // highest number first, and skip(n - 1) selects the Nth value.
        // =========================================================

        List<Integer> numbers =
                Arrays.asList(10, 30, 20, 30, 40, 20, 50);

        int n = 3;

        Optional<Integer> nthHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst();

        if (nthHighest.isPresent()) {
            System.out.println("\nQ194 - " + n
                    + "rd highest distinct number: " + nthHighest.get());
        } else {
            System.out.println("\nQ194 - There are fewer than "
                    + n + " distinct numbers.");
        }

    }
}
