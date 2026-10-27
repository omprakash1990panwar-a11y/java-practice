package interview.question;

import java.util.Optional;

public class Question135 {

    // --------------------------------------------------
    // Question 135: Transform an Optional using map()
    // Important: map() transforms a present value into another value.
    // If the mapper returns null, the resulting Optional is empty.
    // --------------------------------------------------


    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Optional<String> employeeName = Optional.of("Amit");

        // Use map()
        // Important: map() applies a function to the value inside the Optional.
        Optional<String> upperCaseName =
                employeeName.map(String::toUpperCase);

        System.out.println("Uppercase name: " +
                upperCaseName.orElse("Unknown"));
    }

}
