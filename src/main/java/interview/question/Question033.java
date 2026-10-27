package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question033 {
    public static void main(String[] args) {
        // Extract all words from sentences, then find unique words.
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Spring Boot is popular",
                "Streams simplify coding",
                "Streams simplify coding",
                "Streams simplify coding"
        );

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .toList();

        System.out.println("Q33 - All words: " + words);

        List<String> uniqueWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .distinct()
                .toList();

        System.out.println("Q33 - Unique words: " + uniqueWords);
    }
}
