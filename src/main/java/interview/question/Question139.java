package interview.question;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question139 {

    // --------------------------------------------------
    // Question 139: Avoid NullPointerException when processing names
    // Important: filter out null names before calling methods on them.
    // Optional.ofNullable() safely wraps a possibly null value.
    // --------------------------------------------------


    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        List<String> names = Arrays.asList(
                "amit", null, "priya", "rahul", null
        );

        // Use ofNullable() and filter()
        // Important: ofNullable() protects against a null value.
        List<String> safeNames = names.stream()
                .filter(n -> n != null)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Safe names: " + safeNames);

        // Use ofNullable()
        Optional<String> nullableName = Optional.ofNullable(null);

        System.out.println("Nullable name: " +
                nullableName.orElse("Name not available"));
    }

}
