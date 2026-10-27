package interview.UtilPackages;

import java.util.List;

public class ProductOrder {
    private final int orderId;
    private final List<Product> products;

    public ProductOrder(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }
}
