package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question003 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 003: Convert all names to uppercase using map().
        // map() transforms each string into its uppercase equivalent.

        Map<String, Long> nameLengh = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(nameLengh);

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase).toList();

        System.out.println("Q003 - Uppercase names: " + upperCaseNames);




        List<String> upperCaseString = names.stream().map(str->str.toUpperCase()).collect(Collectors.toList());
        System.out.println("Last " + upperCaseString);


        Map<String, Long> stringLengh2 = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringLengh2);

        Map<Integer, Long> numberRepeat = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(numberRepeat);
    }
}
