package interview.question;

import interview.practice.Day17;

import java.util.*;
import java.util.stream.Collectors;

public class Question168 {

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
        // Question 167: Calculate total order value per customer.
        // Concept: group by customer, then sum quantity * unit price.
        // =========================================================

        Map<String, Double> totalByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Order::getTotal)
                ));

        System.out.println("Q167 - Total order value per customer: "
                + totalByCustomer);


        // =========================================================
        // Question 168: Find the customer with the highest spending.
        // Concept: compare each customer's aggregated spending.
        // =========================================================

        Optional<Map.Entry<String, Double>> highestSpendingCustomer =
                totalByCustomer.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue());

        highestSpendingCustomer.ifPresent(entry ->
                System.out.println("Q168 - Highest spending customer: "
                        + entry.getKey() + " = " + entry.getValue())
        );
    }
}
