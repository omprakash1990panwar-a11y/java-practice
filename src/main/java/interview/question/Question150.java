package interview.question;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question150 {
    public static void main(String[] args) {

        // --------------------------------------------------
        // Question 150: Find the most frequent word in a paragraph
        // Important: Normalize to lowercase and remove punctuation.
        // groupingBy() counts words; max() finds the highest frequency.
        // If multiple words tie, this example returns one of the tied words.
        // --------------------------------------------------

        System.out.println("Question 150:");

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
