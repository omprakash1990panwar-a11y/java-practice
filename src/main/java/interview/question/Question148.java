package interview.question;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question148 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 148: Count vowels and consonants
        // Important: Normalize to lowercase and consider English letters
        // only. Spaces, digits and punctuation are ignored.
        // --------------------------------------------------

        System.out.println("Question 148:");

        String input148 = "Java Streams 8!";

        long vowels = input148.toLowerCase().chars()
                .filter(Character::isLetter)
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();

        long consonants = input148.toLowerCase().chars()
                .filter(Character::isLetter)
                .filter(c -> "aeiou".indexOf(c) < 0)
                .count();

        System.out.println("Text: " + input148);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
