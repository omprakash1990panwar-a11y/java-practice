
package interview.practice;

import interview.UtilPackages.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Day17 {

    public static void main(String[] args) {

        /*
         * IMPORTANT NOTES:
         *
         * 1. This class uses Java 8 Stream API.
         * 2. The existing Employee class is imported; do not recreate it here.
         * 3. LinkedHashSet preserves encounter order while removing duplicates.
         * 4. Collectors.groupingBy() groups elements by a key.
         * 5. Collectors.summingDouble() calculates totals.
         * 6. Map.merge() combines values for duplicate keys.
         * 7. Order is a separate inner class because Employee represents employees,
         *    not customer orders.
         */

        // =========================================================
        // Question 161: Find common values between two lists.
        // Concept: retain values that exist in both collections.
        // =========================================================

        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(30, 40, 50, 60, 70);

        Set<Integer> commonValues = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("Q161 - Common values: " + commonValues);


        // =========================================================
        // Question 162: Remove duplicates while preserving encounter order.
        // Concept: distinct() preserves the encounter order of an ordered stream.
        // =========================================================

        List<String> names = Arrays.asList(
                "Amit", "Priya", "Amit", "Rahul", "Priya", "Neha"
        );

        List<String> uniqueNames = names.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Q162 - Unique names: " + uniqueNames);


        // =========================================================
        // Question 163: Find elements appearing in exactly one of two lists.
        // Concept: symmetric difference — present in either list, but not both.
        // =========================================================

        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> firstSet = new LinkedHashSet<>(firstList);
        Set<Integer> secondSet = new LinkedHashSet<>(secondList);

        Set<Integer> onlyInFirst = firstSet.stream()
                .filter(value -> !secondSet.contains(value))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> onlyInSecond = secondSet.stream()
                .filter(value -> !firstSet.contains(value))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> exclusiveValues = new LinkedHashSet<>(onlyInFirst);
        exclusiveValues.addAll(onlyInSecond);

        System.out.println("Q163 - Values appearing in exactly one list: "
                + exclusiveValues);


        // =========================================================
        // Question 164: Compare two maps and find differing entries.
        // Concept: compare the union of keys and use Objects.equals()
        // to safely compare values, including null values.
        // =========================================================

        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("A", 100);
        map1.put("B", 200);
        map1.put("C", 300);

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("A", 100);
        map2.put("B", 250);
        map2.put("D", 400);

        Set<String> allKeys = new LinkedHashSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        Map<String, String> differingEntries = allKeys.stream()
                .filter(key -> !Objects.equals(map1.get(key), map2.get(key))
                        || map1.containsKey(key) != map2.containsKey(key))
                .collect(Collectors.toMap(
                        key -> key,
                        key -> "map1=" + map1.get(key)
                                + ", map2=" + map2.get(key),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Q164 - Differing entries: " + differingEntries);


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


        // =========================================================
        // Question 169: Extract unique products from customer orders.
        // Concept: map() extracts product names; distinct() removes duplicates.
        // =========================================================

        List<String> uniqueProducts = orders.stream()
                .map(Order::getProduct)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Q169 - Unique products: " + uniqueProducts);


        // =========================================================
        // Question 170: Rank products by sales amount.
        // Concept: group by product, sum each product's order value,
        // then sort entries by total sales in descending order.
        // =========================================================

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


    // =============================================================
    // Inner class for order-related questions.
    // The existing Employee class remains unchanged.
    // =============================================================

    public static class Order {

        private String customer;
        private String product;
        private int quantity;
        private double unitPrice;

        public Order(String customer, String product,int quantity, double unitPrice) {
            this.customer = customer;
            this.product = product;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getCustomer() {
            return customer;
        }

        public String getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getTotal() {
            return quantity * unitPrice;
        }

        @Override
        public String toString() {
            return product + "(qty=" + quantity
                    + ", total=" + getTotal() + ")";
        }
    }
}
