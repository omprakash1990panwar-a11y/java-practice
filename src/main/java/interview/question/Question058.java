package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question058 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        // 058. Join strings using Collectors.joining()
        String joinedNames = names.stream()
                .distinct()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("\n058. Joining Strings:\n" + joinedNames);
    }
}
