package interview.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day15 {

    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 141: Reverse a string using streams
        // Important: IntStream.range() generates character indexes.
        // Collect characters in reverse index order.
        // --------------------------------------------------

        System.out.println("Question 141:");

        String text = "Java";

        String reversed = IntStream.range(0, text.length())
                .mapToObj(i -> text.charAt(text.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reversed);


        // --------------------------------------------------
        // Question 142: Find the first non-repeated character
        // Important: LinkedHashMap preserves character insertion order.
        // groupingBy() counts occurrences; findFirst() selects the first
        // character whose count is exactly one.
        // --------------------------------------------------

        System.out.println("\nQuestion 142:");

        String input142 = "swiss";

        Map<Character, Long> frequency142 = input142.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Character firstNonRepeated = frequency142.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("String: " + input142);
        System.out.println("First non-repeated character: "
                + firstNonRepeated);


        // --------------------------------------------------
        // Question 143: Find the first repeated character
        // Important: Find the first character in the original string
        // whose total frequency is greater than one.
        // --------------------------------------------------

        System.out.println("\nQuestion 143:");

        String input143 = "programming";

        Map<Character, Long> frequency143 = input143.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        Character firstRepeated = input143.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> frequency143.get(ch) > 1)
                .findFirst()
                .orElse(null);

        System.out.println("String: " + input143);
        System.out.println("First repeated character: " + firstRepeated);


        // --------------------------------------------------
        // Question 144: Count occurrences of each character
        // Important: groupingBy() groups equal characters;
        // counting() counts how many times each character appears.
        // --------------------------------------------------

        System.out.println("\nQuestion 144:");

        String input144 = "programming";

        Map<Character, Long> characterCount = input144.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("Character occurrences: " + characterCount);


        // --------------------------------------------------
        // Question 145: Check whether two strings are anagrams
        // Important: Anagrams contain the same characters with the
        // same frequencies. This example ignores case and whitespace.
        // --------------------------------------------------

        System.out.println("\nQuestion 145:");

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


        // --------------------------------------------------
        // Question 146: Find duplicate characters in a string
        // Important: Keep only characters with frequency greater than one.
        // LinkedHashMap maintains their first-appearance order.
        // --------------------------------------------------

        System.out.println("\nQuestion 146:");

        String input146 = "programming";

        Map<Character, Long> frequency146 = input146.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        List<Character> duplicateCharacters = frequency146.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate characters: "
                + duplicateCharacters);


        // --------------------------------------------------
        // Question 147: Find unique characters in a string
        // Important: "Unique" here means characters appearing exactly once.
        // --------------------------------------------------

        System.out.println("\nQuestion 147:");

        String input147 = "programming";

        Map<Character, Long> frequency147 = input147.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        List<Character> uniqueCharacters = frequency147.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Unique characters: " + uniqueCharacters);


        // --------------------------------------------------
        // Question 148: Count vowels and consonants
        // Important: Normalize to lowercase and consider English letters
        // only. Spaces, digits and punctuation are ignored.
        // --------------------------------------------------

        System.out.println("\nQuestion 148:");

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


        // --------------------------------------------------
        // Question 149: Find the longest word in a sentence
        // Important: Split the sentence into words, then use max()
        // with a comparator based on word length.
        // --------------------------------------------------

        System.out.println("\nQuestion 149:");

        String sentence = "Java streams make coding more powerful";

        String longestWord = Arrays.stream(sentence.split("\\s+"))
                .max((word1, word2) ->
                        Integer.compare(word1.length(), word2.length()))
                .orElse("");

        System.out.println("Sentence: " + sentence);
        System.out.println("Longest word: " + longestWord);


        // --------------------------------------------------
        // Question 150: Find the most frequent word in a paragraph
        // Important: Normalize to lowercase and remove punctuation.
        // groupingBy() counts words; max() finds the highest frequency.
        // If multiple words tie, this example returns one of the tied words.
        // --------------------------------------------------

        System.out.println("\nQuestion 150:");

        String paragraph =
                "Java is powerful. Java is popular, and Java is widely used.";

        Map<String, Long> wordFrequency = Arrays.stream(
                        paragraph.toLowerCase()
                                .replaceAll("[^a-z0-9\\s]", "")
                                .trim()
                                .split("\\s+")
                )
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Map.Entry<String, Long> mostFrequentWord = wordFrequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (mostFrequentWord != null) {
            System.out.println("Word: " + mostFrequentWord.getKey());
            System.out.println("Frequency: " + mostFrequentWord.getValue());
        } else {
            System.out.println("No words found.");
        }
    }
}