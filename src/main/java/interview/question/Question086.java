package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question086 {

    public static void main(String[] args) {

        int target = 3;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // =====================================================
        // Q086. anyMatch() - Check whether a list contains a target
        //
        // IMPORTANT NOTES:
        // 1. anyMatch() returns true if at least one element matches.
        // 2. It stops processing when a match is found.
        // 3. It returns false if no element matches.
        // 4. For an empty stream, anyMatch() returns false.
        // 5. For a simple list, List.contains() is another option.
        // =====================================================

        boolean containsTarget = numbers.stream()
                .anyMatch(n -> n == target);

        System.out.println("Q086. List contains target " + target
                + ": " + containsTarget);
    }
}
