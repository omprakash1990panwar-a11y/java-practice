package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question014 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Priya", "Neha", "Vikas",
                "Sneha", "Arjun", "Pooja", "Rohit", "Anjali"
        );

        // Question 014: Convert names into their lengths using map().
        // String::length returns the character count of each name.
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Q014 - Name lengths: " + nameLengths);
    }
}
