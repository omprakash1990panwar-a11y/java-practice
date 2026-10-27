package interview.question;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question161 {
    public static void main(String[] args) {

        /*
         * IMPORTANT NOTES:
         *
         * 1. This class uses Java 8 Stream API.
         * 2. The existing Employee class is imported; do not recreate it here.
         * 3. LinkedHashSet preserves encounter order while removing duplicates.
         * 4. Collectors.groupingBy() groups elements by a key.
         * 5. Collectors.summingDouble() calculates totals.
         * 6. Map.merge() combines values for duplicate keys.
         * 7. Order is a separate inner class because Employee represents employees,
         *    not customer orders.
         */

        // =========================================================
        // Question 161: Find common values between two lists.
        // Concept: retain values that exist in both collections.
        // =========================================================

        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(30, 40, 50, 60, 70);

        Set<Integer> commonValues = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("Q161 - Common values: " + commonValues);

    }
}
