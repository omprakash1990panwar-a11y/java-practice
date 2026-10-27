package interview.question;

import java.util.Optional;

/**
 * Question 131: Use Optional.ofNullable() safely
 */
public class Question131 {

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        String name = null;

        // Use Optional.ofNullable() safely
        // Important: ofNullable() accepts both null and non-null values.
        // Unlike Optional.of(), it does not throw NPE for a null argument.
        Optional<String> optionalName = Optional.ofNullable(name);

        System.out.println("Is name present? " + optionalName.isPresent());
        System.out.println("Name: " +
                optionalName.orElse("Unknown"));
    }
}
