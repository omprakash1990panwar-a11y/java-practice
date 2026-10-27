package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question082 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Java", "Streams", "", "Spring");

        // =====================================================
        // Q082. noneMatch() - Check whether no string is empty
        //
        // IMPORTANT NOTES:
        // 1. noneMatch() returns true if no element matches.
        // 2. It returns false as soon as a matching element is found.
        // 3. For an empty stream, noneMatch() returns true.
        // 4. This predicate assumes strings are not null.
        // =====================================================

        boolean noEmptyStrings = strings.stream()
                .noneMatch(s -> s.isEmpty());

        System.out.println("Q082. No strings are empty: "
                + noEmptyStrings);
    }
}