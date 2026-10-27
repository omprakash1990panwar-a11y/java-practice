package interview.question;

import java.util.HashMap;
import java.util.Map;

public class Question186 {
    public static void main(String[] args) {

        // =========================================================
        // Question 186: Find the longest substring without duplicate characters.
        //
        // Concept:
        // Sliding-window algorithm.
        // A map records the last index of each character.
        // Move the window's left boundary when a duplicate is found.
        // =========================================================

        String input = "abcabcbb";

        Map<Character, Integer> lastSeenIndex = new HashMap<>();

        int left = 0;
        int longestLength = 0;
        int longestStart = 0;

        for (int right = 0; right < input.length(); right++) {

            char currentCharacter = input.charAt(right);

            if (lastSeenIndex.containsKey(currentCharacter)
                    && lastSeenIndex.get(currentCharacter) >= left) {

                left = lastSeenIndex.get(currentCharacter) + 1;
            }

            lastSeenIndex.put(currentCharacter, right);

            int currentLength = right - left + 1;

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestStart = left;
            }
        }

        String longestSubstring = input.substring(
                longestStart, longestStart + longestLength
        );

        System.out.println("\nQ186 - Input string: " + input);
        System.out.println("Q186 - Longest substring: " + longestSubstring);
        System.out.println("Q186 - Length: " + longestLength);

    }
}
