package interview.question;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question145 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 145: Check whether two strings are anagrams
        // Important: Anagrams contain the same characters with the
        // same frequencies. This example ignores case and whitespace.
        // --------------------------------------------------

        System.out.println("Question 145:");

        String first = "Dormitory";
        String second = "Dirty room";

        String normalizedFirst = first.replaceAll("\\s+", "")
                .toLowerCase();

        String normalizedSecond = second.replaceAll("\\s+", "")
                .toLowerCase();

        boolean areAnagrams = normalizedFirst.length()
                == normalizedSecond.length()
                && normalizedFirst.chars().sorted().boxed()
                .collect(Collectors.toList())
                .equals(
                        normalizedSecond.chars().sorted().boxed()
                                .collect(Collectors.toList())
                );

        System.out.println("First string: " + first);
        System.out.println("Second string: " + second);
        System.out.println("Are anagrams? " + areAnagrams);
    }
}
