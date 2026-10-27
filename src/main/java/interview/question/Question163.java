package interview.question;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question163 {

    public static void main(String[] args) {

        // =========================================================
        // Question 163: Find elements appearing in exactly one of two lists.
        // Concept: symmetric difference — present in either list, but not both.
        // =========================================================

        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> firstSet = new LinkedHashSet<>(firstList);
        Set<Integer> secondSet = new LinkedHashSet<>(secondList);

        Set<Integer> onlyInFirst = firstSet.stream()
                .filter(value -> !secondSet.contains(value))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> onlyInSecond = secondSet.stream()
                .filter(value -> !firstSet.contains(value))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> exclusiveValues = new LinkedHashSet<>(onlyInFirst);
        exclusiveValues.addAll(onlyInSecond);

        System.out.println("Q163 - Values appearing in exactly one list: "
                + exclusiveValues);
    }
}
