package interview.question;

import interview.practice.Day17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question169 {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("Amit", "Laptop", 1, 50000),
                new Order("Amit", "Mouse", 2, 500),
                new Order("Priya", "Laptop", 1, 50000),
                new Order("Priya", "Keyboard", 2, 1500),
                new Order("Rahul", "Mouse", 3, 500),
                new Order("Rahul", "Laptop", 1, 50000)
        );



        // =========================================================
        // Question 169: Extract unique products from customer orders.
        // Concept: map() extracts product names; distinct() removes duplicates.
        // =========================================================

        List<String> uniqueProducts = orders.stream()
                .map(Order::getProduct)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Q169 - Unique products: " + uniqueProducts);
    }
}
