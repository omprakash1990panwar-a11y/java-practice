package interview.question;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question170 {

    public static void main(String[] args) {

        // =========================================================
        // Question 170: Rank products by sales amount.
        // Concept: group by product, sum each product's order value,
        // then sort entries by total sales in descending order.
        // =========================================================

        List<Order> orders = Arrays.asList(
                new Order("Amit", "Laptop", 1, 50000),
                new Order("Amit", "Mouse", 2, 500),
                new Order("Priya", "Laptop", 1, 50000),
                new Order("Priya", "Keyboard", 2, 1500),
                new Order("Rahul", "Mouse", 3, 500),
                new Order("Rahul", "Laptop", 1, 50000)
        );



        Map<String, Double> productSales = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct,
                        Collectors.summingDouble(Order::getTotal)
                ));

        Map<String, Double> rankedProducts = productSales.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Q170 - Products ranked by sales amount:");

        int rank = 1;
        for (Map.Entry<String, Double> entry : rankedProducts.entrySet()) {
            System.out.println(rank + ". " + entry.getKey()
                    + " -> " + entry.getValue());
            rank++;
        }
    }
    }

