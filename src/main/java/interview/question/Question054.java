package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question054 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Amit",
                "Neha", "Rahul", "Amit", "Neha"
        );

        // 054. Handle duplicate keys while collecting a Map
        Map<String, Integer> duplicateKeyMap = names.stream().distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("\n054. Handle duplicate keys:\n" + duplicateKeyMap);
    }
}
