package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question037 {
    public static void main(String[] args) {
        // Convert strings into character streams.
        List<String> characterWords = Arrays.asList("Java", "Code");

        List<Integer> characterCodes = characterWords.stream()
                .flatMapToInt(String::chars)
                .boxed()
                .toList();

        System.out.println("Q37 - Character codes: " + characterCodes);

        List<Character> charList = characterWords.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .toList();

        System.out.println("Q37 - Character list: " + charList);
    }
}
