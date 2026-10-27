package interview.question;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question166 {

    public static void main(String[] args) {

        // =========================================================
        // Sample orders for Questions 166–170.
        // Each order has a customer, product, quantity, and unit price.
        // =========================================================

        List<Order> orders = Arrays.asList(
                new Order("Amit", "Laptop", 1, 50000),
                new Order("Amit", "Mouse", 2, 500),
                new Order("Priya", "Laptop", 1, 50000),
                new Order("Priya", "Keyboard", 2, 1500),
                new Order("Rahul", "Mouse", 3, 500),
                new Order("Rahul", "Laptop", 1, 50000)
        );


        // =========================================================
        // Question 166: Group orders by customer.
        // Concept: groupingBy() collects orders under each customer name.
        // =========================================================

        Map<String, List<Order>> ordersByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        System.out.println("Q166 - Orders grouped by customer:");

        ordersByCustomer.forEach((customer, customerOrders) ->
                System.out.println(customer + " -> " + customerOrders)
        );
 }
}
