package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question025 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        // Question 025: Create a map with name as key and character count as value.
        // The supplied names are unique, so no duplicate-key merge function is needed.
        Map<String, Integer> nameCharacterCounts = names.stream().distinct()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println("Q025 - Name character counts: " + nameCharacterCounts);
    }
}
