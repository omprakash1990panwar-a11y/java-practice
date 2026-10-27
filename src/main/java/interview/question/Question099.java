package interview.question;

import interview.UtilPackages.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Question099 {

    public static void main(String[] args) {

        // =====================================================
        // Q099. Find the top two products by sales.
        //
        // IMPORTANT NOTES:
        // 1. Product data should contain a product name and sales value.
        // 2. comparingInt() compares products using their sales.
        // 3. reversed() puts the highest sales first.
        // 4. limit(2) selects the top two products.
        // 5. This question can be solved with the same approach
        //    used to find the highest-paid employees.
        // =====================================================

        // Product is represented here by a Map.Entry:
        // key = product name, value = sales.

        Map<String, Integer> productSales = new java.util.LinkedHashMap<>();
        productSales.put("Laptop", 500);
        productSales.put("Mobile", 900);
        productSales.put("Tablet", 300);
        productSales.put("Monitor", 700);
        productSales.put("Keyboard", 200);

        List<Map.Entry<String, Integer>> topTwoProducts =
                productSales.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .limit(2)
                        .collect(Collectors.toList());

        System.out.println("\nQ099. Top two products by sales: "
                + topTwoProducts);
    }
}