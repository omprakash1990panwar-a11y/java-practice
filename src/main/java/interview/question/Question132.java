package interview.question;

import java.util.Optional;

/**
 * Question 132: Use orElse() and orElseGet()
 */
public class Question132 {

    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Optional<String> existingName = Optional.of("Amit");

        // Use orElse() and orElseGet()
        // Important: orElse() evaluates its fallback eagerly.
        // orElseGet() calls its Supplier only when the Optional is empty.
        String result1 = existingName.orElse(getDefaultName());
        String result2 = existingName.orElseGet(() -> getDefaultName());

        System.out.println("orElse result: " + result1);
        System.out.println("orElseGet result: " + result2);
    }

    private static String getDefaultName() {
        System.out.println("Default value method executed");
        return "Guest";
    }
}
