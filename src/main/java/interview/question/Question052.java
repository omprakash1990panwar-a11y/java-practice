package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question052 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        // 052. Collect unique elements into a Set
        Set<String> uniqueNames = names.stream()
                .collect(Collectors.toSet());

        System.out.println("\n052. Collect unique elements into Set:\n" + uniqueNames);
    }
}
