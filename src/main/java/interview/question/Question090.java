package interview.question;

import interview.UtilPackages.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Question090 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // =====================================================
        // Q090. Compare findFirst() and findAny()
        //
        // IMPORTANT NOTES:
        // 1. findFirst() returns the first match in encounter order.
        // 2. findAny() may return any matching element.
        // 3. Both return Optional<T>.
        // 4. Both are short-circuiting terminal operations.
        // 5. With a sequential ordered stream, findAny() often returns
        //    the first match, but this is not guaranteed.
        // 6. Do not depend on findAny() for ordered selection.
        // =====================================================

        Optional<Integer> firstNumber = numbers.stream()
                .filter(n -> n > 2)
                .findFirst();

        Optional<Integer> anyNumber = numbers.stream()
                .filter(n -> n > 2)
                .findAny();

        System.out.println("Q090. findFirst() result: "
                + firstNumber.orElse(null));

        System.out.println("Q090. findAny() result: "
                + anyNumber.orElse(null));
    }
    }

