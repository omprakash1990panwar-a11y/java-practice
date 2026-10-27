package interview.question;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question184 {
    public static void main(String[] args) {



        // =========================================================
        // Question 184: Group anagrams together.
        //
        // Concept:
        // Words that contain the same characters have the same sorted
        // character sequence. Use that sequence as the grouping key.
        // =========================================================

        List<String> words = Arrays.asList(
                "listen", "silent", "enlist",
                "rat", "tar", "art",
                "evil", "vile"
        );

        Map<String, List<String>> anagramGroups = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.chars()
                                .sorted()
                                .collect(
                                        StringBuilder::new,
                                        StringBuilder::appendCodePoint,
                                        StringBuilder::append
                                )
                                .toString(),
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        System.out.println("\nQ184 - Anagram groups:");

        anagramGroups.values().forEach(System.out::println);
    }
}
