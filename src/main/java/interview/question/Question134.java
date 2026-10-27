package interview.question;

import java.util.Optional;

public class Question134 {


    // --------------------------------------------------
    // Question 134: Filter an Optional value
    // Important: filter() keeps the value only when the condition is true.
    // Otherwise, it returns an empty Optional.
    // --------------------------------------------------


    public static void main(String[] args) {

        // Sample data for Optional and null-handling practice
        Optional<Integer> salary = Optional.of(60000);

        // Use filter()
        // Important: filter() applies a predicate to the value inside the Optional.
        Optional<Integer> filteredSalary =
                salary.filter(s -> s >= 50000);

        System.out.println("Filtered salary: " +
                filteredSalary.orElse(0));
    }

}
