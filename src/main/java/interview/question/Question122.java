package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Question122 {

    /**
     * Find elements that appear only once in a list of words
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Question 122: Find elements that appear only once");

        // List of words
        List<String> words = Arrays.asList(
                "Java", "Spring", "Java", "Docker",
                "Spring", "Java", "Microservices"
        );

        // Group words by their value (i.e., collect into a map)
        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        // Filter the map for words that appear only once
        List<String> uniqueWords = wordFrequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Elements appearing once: " + uniqueWords);




        // Group words by their value (i.e., collect into a map)
        List<String> wordFrequency2 = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet()
                .stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey).toList();


        System.out.println("Elements appearing once: " +wordFrequency2);
    }
}
