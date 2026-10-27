package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question108 {

    public static void main(String[] args) {

        // Question 108: Find the intersection of two lists.
        // IMPORTANT:
        // Intersection means elements present in both lists.
        // distinct() returns each common value only once.
        // This example preserves the order of firstList.

        System.out.println("\nQuestion 108: Find the intersection of two lists");

        List<Integer> firstList =Arrays.asList(10, 20, 30, 40, 50, 20);

        List<Integer> secondList =Arrays.asList(30, 40, 50, 60, 70);

        List<Integer> intersection =firstList.stream().filter(secondList::contains).distinct().toList();

        System.out.println("Intersection: " + intersection);
    }
}
