package interview.question;

import java.util.Optional;

public class Question140 {


    // --------------------------------------------------
    // Question 140: Explain why Optional.get() should not be used blindly
    // Important: get() throws NoSuchElementException when Optional is empty.
    // Prefer orElse(), orElseGet(), orElseThrow(), or ifPresent().
    // --------------------------------------------------


    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Optional<String> presentValue = Optional.of("Java");

        System.out.println("Present value: " + presentValue.get());

        Optional<String> missingValue = Optional.empty();

        // Unsafe approach:
        // missingValue.get(); // Throws NoSuchElementException

        // Safe approach:
        System.out.println("Missing value: " + missingValue.orElse("Default Value"));
    }

}
