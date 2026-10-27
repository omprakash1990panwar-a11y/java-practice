package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question053 {
    public static void main(String[] args) {
        // 053. Convert a List into a Map using toMap() with character count in each name
        List<String> simpleNames = Arrays.asList(
                "Amit", "Priya", "Rahul",
                "Amit", "Priya", "Rahul",
                "Ompraksh", "Karan"
        );

        Map<String, Integer> nameLengthMap = simpleNames.stream().distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("\n053. List to Map:\n" + nameLengthMap);
    }
}
