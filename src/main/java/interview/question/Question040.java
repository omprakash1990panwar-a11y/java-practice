package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question040 {
    public static void main(String[] args) {
        // Convert strings to uppercase and lowercase.
        List<String> names = Arrays.asList("amit", "priya", "rahul");

        names = names.stream()
                .map(name -> name.toUpperCase())
                .toList();

        System.out.println("Q40 - Uppercase (lambda): " + names);

        names = names.stream()
                .map(name -> name.toLowerCase())
                .collect(Collectors.toList());

        System.out.println("Q40 - Lowercase (Collectors): " + names);

        names = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Q40 - Uppercase (method reference): " + names);

        // Additional flatMap example: flatten nested integers.
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> numberCombinedList = numbers.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Q40 - Flattened integer list: " + numberCombinedList);
    }
}
