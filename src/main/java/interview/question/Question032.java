package interview.question;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Question032 {
    public static void main(String[] args) {
        // Flatten a List of Sets into one List.
        List<Set<String>> sets = Arrays.asList(
                new LinkedHashSet<>(Arrays.asList("Ramesh", "Mukesh", "Madhav","Ramesh")),
                new LinkedHashSet<>(Arrays.asList("Ram Singh", "Rohit Raj")),
                new LinkedHashSet<>(Arrays.asList("Uday Panwar", "Gaurav"))
        );

        List<String> flatList = sets.stream()
                .flatMap(Set::stream)
                .toList();

        System.out.println("Q32 - Flattened sets: " + flatList);
    }
}
