package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question173 {
    public static void main(String[] args) {
        // =========================================================
        // Question 173: Convert a parallel stream to sequential.
        // Concept: sequential() switches the pipeline back to sequential mode.
        // =========================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sequentialSumAgain = numbers.parallelStream()
                .sequential()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Q173 - Sum after sequential(): " + sequentialSumAgain);
    }
}
