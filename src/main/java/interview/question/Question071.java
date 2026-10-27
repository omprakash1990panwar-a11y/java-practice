package interview.question;

import java.util.*;
import java.util.stream.Collectors;

public class Question071 {

    public static void main(String[] args) {

        // Create a list of numbers
        List<Integer> numbers = Arrays.asList(
                10, 15, 20, 25, 30, 35, 40, 45, 50
        );

        // --------------------------------------------------
        // 1. Partition numbers into even and odd
        // Downstream collector: toList()
        // --------------------------------------------------
        Map<Boolean, List<Integer>> evenOddPartition =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.toList()
                        ));

        System.out.println("1. Even numbers: "
                + evenOddPartition.get(true));
        System.out.println("1. Odd numbers: "
                + evenOddPartition.get(false));


        // --------------------------------------------------
        // 2. Count even and odd numbers
        // Downstream collector: counting()
        // --------------------------------------------------
        Map<Boolean, Long> evenOddCount =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.counting()
                        ));

        System.out.println("\\n2. Even count: "
                + evenOddCount.get(true));
        System.out.println("2. Odd count: "
                + evenOddCount.get(false));


        // --------------------------------------------------
        // 3. Calculate the sum of even and odd numbers
        // Downstream collector: summingInt()
        // --------------------------------------------------
        Map<Boolean, Integer> evenOddSum =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.summingInt(Integer::intValue)
                        ));

        System.out.println("\\n3. Even sum: "
                + evenOddSum.get(true));
        System.out.println("3. Odd sum: "
                + evenOddSum.get(false));


        // --------------------------------------------------
        // 4. Calculate the average of even and odd numbers
        // Downstream collector: averagingInt()
        // --------------------------------------------------
        Map<Boolean, Double> evenOddAverage =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.averagingInt(Integer::intValue)
                        ));

        System.out.println("\\n4. Even average: "
                + evenOddAverage.get(true));
        System.out.println("4. Odd average: "
                + evenOddAverage.get(false));


        // --------------------------------------------------
        // 5. Collect even and odd numbers into Sets
        // Downstream collector: toSet()
        // --------------------------------------------------
        Map<Boolean, Set<Integer>> evenOddSet =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.toSet()
                        ));

        System.out.println("\\n5. Even set: "
                + evenOddSet.get(true));
        System.out.println("5. Odd set: "
                + evenOddSet.get(false));


        // --------------------------------------------------
        // 6. Find the maximum even and odd numbers
        // Downstream collector: maxBy()
        // --------------------------------------------------
        Map<Boolean, Optional<Integer>> evenOddMax =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.maxBy(
                                        Comparator.naturalOrder()
                                )
                        ));

        System.out.println("\\n6. Maximum even number: "
                + evenOddMax.get(true).orElse(null));
        System.out.println("6. Maximum odd number: "
                + evenOddMax.get(false).orElse(null));


        // --------------------------------------------------
        // 7. Collect even and odd numbers as comma-separated text
        // Downstream collector: joining()
        // --------------------------------------------------
        Map<Boolean, String> evenOddJoining =
                numbers.stream()
                        .collect(Collectors.partitioningBy(
                                number -> number % 2 == 0,
                                Collectors.mapping(
                                        String::valueOf,
                                        Collectors.joining(", ")
                                )
                        ));

        System.out.println("\\n7. Even numbers as text: "
                + evenOddJoining.get(true));
        System.out.println("7. Odd numbers as text: "
                + evenOddJoining.get(false));
    }
}
