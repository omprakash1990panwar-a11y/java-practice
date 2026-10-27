package interview.question;

import java.util.Arrays;
import java.util.List;


public class Question081 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(-1,1, 2, 3, 4, 5);

        // =====================================================
        // Q081. allMatch() - Check whether all numbers are positive
        //
        // IMPORTANT NOTES:
        // 1. allMatch() returns true only if every element matches.
        // 2. It returns false as soon as one element fails.
        // 3. It is a short-circuiting terminal operation.
        // 4. For an empty stream, allMatch() returns true.
        // =====================================================

        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("Q081. All numbers are positive: "+ allPositive);
    }
}