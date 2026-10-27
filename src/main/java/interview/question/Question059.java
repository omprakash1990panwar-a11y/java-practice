package interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Question059 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        // 059. Create an unmodifiable collection using Java 8
        List<String> mutableList = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        List<String> unmodifiableList = Collections.unmodifiableList(
                new ArrayList<>(mutableList)
        );

        System.out.println("\n059. Unmodifiable List:\n" + unmodifiableList);

        // Throws UnsupportedOperationException:
        // unmodifiableList.add("Karan");
    }
}
