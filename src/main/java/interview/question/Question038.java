package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question038 {
    public static void main(String[] args) {
        // Flatten line items from multiple orders.
        List<Order> ordersWithItems = Arrays.asList(
                new Order(101,
                        Arrays.asList(new Product(1, "Laptop")),
                        Arrays.asList(new LineItem("Laptop", 1), new LineItem("Mouse", 2))),
                new Order(102,
                        Arrays.asList(new Product(2, "Keyboard")),
                        Arrays.asList(new LineItem("Keyboard", 1), new LineItem("Monitor", 2))),
                new Order(103,
                        Arrays.asList(new Product(3, "Headphones")),
                        Arrays.asList(new LineItem("Headphones", 1)))
        );

        List<LineItem> allItems = ordersWithItems.stream()
                .flatMap(order -> order.getLineItems().stream())
                .toList();

        System.out.println("Q38 - All order line items: " + allItems);
    }

    static class Order {
        private final int orderId;
        private final List<Product> products;
        private final List<LineItem> lineItems;

        Order(int orderId, List<Product> products, List<LineItem> lineItems) {
            this.orderId = orderId;
            this.products = products;
            this.lineItems = lineItems;
        }

        public List<LineItem> getLineItems() {
            return lineItems;
        }
    }

    static class Product {
        private final int productId;
        private final String productName;

        Product(int productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }
    }

    static class LineItem {
        private final String productName;
        private final int quantity;

        LineItem(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "LineItem{productName='" + productName + "', quantity=" + quantity + "}";
        }
    }
}
