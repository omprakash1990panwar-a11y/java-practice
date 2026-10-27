package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Question128 {

    /**
     * Find the most frequent word in a sentence
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 128: Find the most frequent word");

        // Sentence to process
        String sentence = "This is a sample sentence for testing the frequency of words";

        // Split the sentence into words
        List<String> words = Arrays.asList(sentence.split("\\s+"));

        // Group words by their value (i.e., collect into a map)
        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        // Find the maximum value in the map
        Map.Entry<String, Long> mostFrequent = wordFrequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (mostFrequent != null) {
            System.out.println("Most frequent word: " + mostFrequent.getKey());
            System.out.println("Frequency: " + mostFrequent.getValue());
        }
    }
}
