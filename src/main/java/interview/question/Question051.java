package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question051 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        // 051. Collect stream elements into a List
        List<String> collectedList = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        System.out.println("051. Collect into List:\n" + collectedList);
    }
}
