package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question057 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        // 057. Convert a Stream into an Array using toArray()
        String[] namesArray = names.stream()
                .filter(name -> name.startsWith("A"))
                .toArray(String[]::new);

        System.out.println("\n057. Stream to Array:\n" + Arrays.toString(namesArray));
    }
}
