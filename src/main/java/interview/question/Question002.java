package interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Question002 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        List<Integer> numbers = Arrays.asList(
                1, 25, 26, 25, 26, 100, 101, 201,
                101, 70, 71, 89, 70, 72, 25, 26
        );

        // Question 002: Filter even numbers.
        // filter() retains only numbers divisible by 2.
        List<Integer> evenList = new ArrayList<>();

        List<Integer> sizeOfString = names.stream().map(str->str.length()).toList();
        System.out.println(sizeOfString);

        Map<String,Long> StringLenghMap = names.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(StringLenghMap);

        List<Integer> evenNumbers = numbers.stream().filter(lo ->lo%2==0).toList();

        System.out.println("Q002 - Even numbers: " + evenNumbers);
    }
}
