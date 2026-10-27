package interview.question;

public class Order {
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
