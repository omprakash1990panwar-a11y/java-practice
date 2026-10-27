package interview.question;

import java.util.Arrays;
import java.util.List;

public class Question039 {
    public static void main(String[] args) {
        // Find unique product IDs and product names across orders.
        List<ProductOrder> productOrders = Arrays.asList(
                new ProductOrder(101, Arrays.asList(
                        new Product(1, "Laptop"),
                        new Product(2, "Mouse"))),
                new ProductOrder(102, Arrays.asList(
                        new Product(2, "Mouse"),
                        new Product(3, "Keyboard"))),
                new ProductOrder(103, Arrays.asList(
                        new Product(1, "Laptop"),
                        new Product(4, "Monitor")))
        );

        List<Integer> uniqueProductIds = productOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getProductId)
                .distinct()
                .toList();

        System.out.println("Q39 - Unique product IDs: " + uniqueProductIds);

        List<String> uniqueProductNames = productOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getProductName)
                .distinct()
                .toList();

        System.out.println("Q39 - Unique product names: " + uniqueProductNames);
    }

    static class ProductOrder {
        private final int orderId;
        private final List<Product> products;

        ProductOrder(int orderId, List<Product> products) {
            this.orderId = orderId;
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }
    }

    static class Product {
        private final int productId;
        private final String productName;

        Product(int productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }
    }
}
