package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question067 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Java", "SQL", "Spring", "API", "Docker",
                "Code", "Stream", "Go", "Python", "AI"
        );

        // 067. Group strings by their length using groupingBy().
        Map<Integer, List<String>> wordsByLength =
                words.stream()
                        .collect(Collectors.groupingBy(String::length));

        System.out.println("\n067. Words grouped by length:");
        wordsByLength.forEach((length, wordList) ->
                System.out.println(length + " -> " + wordList));
    }
}
