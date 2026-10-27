package interview.question;

import java.util.LinkedHashMap;
import java.util.Map;

public class Question165 {

    public static void main(String[] args) {

        // =========================================================
        // Question 165: Merge two maps by summing duplicate values.
        // Concept: Map.merge() adds values when a key already exists.
        // =========================================================

        Map<String, Integer> sales1 = new LinkedHashMap<>();
        sales1.put("Laptop", 10);
        sales1.put("Mouse", 20);
        sales1.put("Keyboard", 5);

        Map<String, Integer> sales2 = new LinkedHashMap<>();
        sales2.put("Laptop", 15);
        sales2.put("Mouse", 10);
        sales2.put("Monitor", 8);

        Map<String, Integer> mergedSales = new LinkedHashMap<>(sales1);

        sales2.forEach((product, quantity) ->
                mergedSales.merge(product, quantity, Integer::sum)
        );

        System.out.println("Q165 - Merged sales: " + mergedSales);

    }
}
