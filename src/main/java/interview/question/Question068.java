package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question068 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "Assembly", "Bash", "C", "C++", "C#", "COBOL", "Dart", "Delphi", "Elixir", "Erlang",
                "Fortran", "F#", "Go", "Groovy", "Haskell", "Java", "JavaScript", "Julia", "Kotlin", "Lisp",
                "Lua", "MATLAB", "Objective-C", "OCaml", "Pascal", "Perl", "PHP", "Prolog", "Python", "R",
                "Ruby", "Rust", "Scala", "Scheme", "SQL", "Swift", "TypeScript", "Visual Basic", "Zig", "Ada"
        );
        // 068. Group words by their first character using groupingBy().
        Map<Character, List<String>> wordsByFirstCharacter =
                words.stream()
                        .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println("\n068. Words grouped by first character:");
        wordsByFirstCharacter.forEach((firstCharacter, wordList) ->
                System.out.println(firstCharacter + " -> " + wordList));
    }
}
