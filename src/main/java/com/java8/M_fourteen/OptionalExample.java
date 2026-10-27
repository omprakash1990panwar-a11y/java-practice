package com.java8.M_fourteen;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // Create an Employee with an email
        Employee empWithEmail = new Employee("Alice", Optional.of("alice@example.com"));

        // Create an Employee without an email
        Employee empWithoutEmail = new Employee("Bob", Optional.empty());

        // Example 1: isPresent() - Check if an email is present
        System.out.println("Email for Alice is present: " + empWithEmail.getEmail().isPresent()); // true
        System.out.println("Email for Bob is present: " + empWithoutEmail.getEmail().isPresent()); // false

        // Example 2: ifPresent() - Perform an action if email is present
        empWithEmail.getEmail().ifPresent(email -> System.out.println("Alice's email: " + email));
        empWithoutEmail.getEmail().ifPresent(email -> System.out.println("Bob's email: " + email)); // Does nothing

        // Example 3: orElse() - Provide a default value if email is not present
        String emailForAlice = empWithEmail.getEmail().orElse("No email provided");
        String emailForBob = empWithoutEmail.getEmail().orElse("No email provided");
        System.out.println("Alice's email: " + emailForAlice);
        System.out.println("Bob's email: " + emailForBob);

        // Example 4: orElseGet() - Use a supplier to provide a default value if email is absent
        String emailForBobUsingSupplier = empWithoutEmail.getEmail().orElseGet(() -> "default@example.com");
        System.out.println("Bob's email using supplier: " + emailForBobUsingSupplier);

        // Example 5: orElseThrow() - Throw an exception if email is absent
        try {
            String emailForBobUsingException = empWithoutEmail.getEmail()
                    .orElseThrow(() -> new IllegalArgumentException("Email not found"));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Example 6: map() - Transform the email if present
        Optional<String> upperCaseEmailForAlice = empWithEmail.getEmail().map(String::toUpperCase);
        System.out.println("Alice's email in uppercase: " + upperCaseEmailForAlice.orElse("No email"));

        // Example 7: flatMap() - Transform and return Optional directly if present
        Optional<String> flatMappedEmailForAlice = empWithEmail.getEmail().flatMap(email -> Optional.of(email.toLowerCase()));
        System.out.println("Alice's email in lowercase: " + flatMappedEmailForAlice.orElse("No email"));

        // Example 8: filter() - Check a condition and return Optional if condition matches
        Optional<String> filteredEmailForAlice = empWithEmail.getEmail().filter(email -> email.contains("example"));
        System.out.println("Alice's email contains 'example': " + filteredEmailForAlice.orElse("No matching email"));
    }
}
