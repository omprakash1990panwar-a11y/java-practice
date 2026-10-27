package interview.question;

import java.util.Optional;

public class Question133 {


    // --------------------------------------------------
    // Question 133: Use orElseThrow() when a value is absent
    // Important: Java 8 uses orElseThrow(Supplier).
    // It throws the supplied exception when the Optional is empty.
    // --------------------------------------------------

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Optional<String> emptyName = Optional.empty();

        // Use orElseThrow()
        // Important: orElseThrow() throws the specified exception if the Optional is empty.
        try {
            String value = emptyName.orElseThrow(
                    () -> new IllegalArgumentException("Name is missing")
            );

            System.out.println(value);

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }}
