package interview.question;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question109 {

    public static void main(String[] args) {

        // Question 109: Find the union of two lists.
        // IMPORTANT:
        // Union combines elements from both lists without duplicates.
        // LinkedHashSet preserves insertion order.
        // Stream.concat() combines the two streams.

        System.out.println("\nQuestion 109: Find the union of two lists");

        List<Integer> unionFirstList =
                Arrays.asList(10, 20, 30, 40);

        List<Integer> unionSecondList =
                Arrays.asList(30, 40, 50, 60);

        List<Integer> union =
                Stream.concat(
                                unionFirstList.stream(),
                                unionSecondList.stream()
                        )
                        .collect(Collectors.toCollection(LinkedHashSet::new)).stream().toList();


        System.out.println("Union: " + union);
    }
}
