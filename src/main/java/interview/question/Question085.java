package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Question085 {

    public static void main(String[] args) {

        List<String> strings =Arrays.asList("Java", "Streams", "", "Spring");

        // =====================================================
        // Q085. Find the first non-empty string.
        //
        // IMPORTANT NOTES:
        // 1. filter() removes strings that do not satisfy the condition.
        // 2. findFirst() returns the first remaining element.
        // 3. orElse() provides a fallback when Optional is empty.
        // 4. This predicate assumes strings are not null.
        // =====================================================

        Optional<String> firstNonEmpty = strings.stream()
                .filter(s -> !s.isEmpty())
                .findFirst();

        System.out.println("Q085. First non-empty string: "
                + firstNonEmpty.orElse("Not found"));
    }
}
