package designPatterns.B_Structural;

import java.util.HashMap;
import java.util.Map;

// Represents a customer placing an order.
class CustomerService {

    public boolean validateCustomer(int customerId) {
        System.out.println("1. Validating customer: " + customerId);
        if (customerId <= 0) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
        return true;
    }
}

// Manages product stock and reservations.
class InventoryService {

    private final Map<Integer, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put(101, 10); // Laptop: 10 available
        stock.put(102, 20); // Mouse: 20 available
    }

    public void reserveStock(int productId, int quantity) {
        System.out.println("2. Checking product availability...");

        int available = stock.getOrDefault(productId, 0);

        if (quantity <= 0 || available < quantity) {
            throw new IllegalStateException("Insufficient stock");
        }

        stock.put(productId, available - quantity);
        System.out.println("   Stock reserved successfully.");
    }

    // Restore stock if payment fails.
    public void releaseStock(int productId, int quantity) {
        stock.merge(productId, quantity, Integer::sum);
        System.out.println("   Reserved stock released.");
    }
}

// Calculates product price and tax.
class PricingService {

    public double calculateTotal(int productId, int quantity) {
        System.out.println("3. Calculating order price...");

        double unitPrice;

        switch (productId) {
            case 101 -> unitPrice = 60000.00;
            case 102 -> unitPrice = 500.00;
            default -> throw new IllegalArgumentException(
                    "Unknown product ID");
        }

        double subtotal = unitPrice * quantity;
        double tax = subtotal * 0.18;

        System.out.printf("   Subtotal: ₹%.2f%n", subtotal);
        System.out.printf("   Tax (18%%): ₹%.2f%n", tax);

        return subtotal + tax;
    }
}

// Processes the customer's payment.
class PayService {

    public boolean processPayment(double amount) {
        System.out.println("4. Processing payment...");

        // Simulates a successful payment.
        // A real application would call a payment gateway.
        if (amount > 0) {
            System.out.printf("   Payment successful: ₹%.2f%n", amount);
            return true;
        }

        return false;
    }
}

// Arranges delivery after successful payment.
class ShippingService {

    public String arrangeShipping(int customerId, int productId) {
        System.out.println("5. Arranging shipment...");

        String trackingId = "SHIP-" + customerId + "-" + productId;

        System.out.println("   Tracking ID: " + trackingId);
        return trackingId;
    }
}

// Notifies the customer about the order.
class NotificationService {

    public void sendConfirmation(int customerId,double amount, String trackingId) {
        System.out.println("6. Sending order confirmation...");
        System.out.println("   Customer ID: " + customerId);
        System.out.printf("   Amount paid: ₹%.2f%n", amount);
        System.out.println("   Tracking ID: " + trackingId);
        System.out.println("   Confirmation sent successfully.");
    }
}

// FACADE: Provides one simple method to coordinate
// the entire order processing workflow.
class OrderFacade {

    private final CustomerService customerService = new CustomerService();

    private final InventoryService inventoryService = new InventoryService();

    private final PricingService pricingService = new PricingService();

    private final PayService paymentService = new PayService();

    private final ShippingService shippingService = new ShippingService();

    private final NotificationService notificationService = new NotificationService();

    public void placeOrder(int customerId,int productId, int quantity) {

        boolean stockReserved = false;
        boolean paymentCompleted = false;

        try {
            // Step 1: Validate customer.
            customerService.validateCustomer(customerId);

            // Step 2: Reserve stock.
            inventoryService.reserveStock(productId, quantity);
            stockReserved = true;

            // Step 3: Calculate final price.
            double total = pricingService.calculateTotal( productId, quantity);

            // Step 4: Process payment.
            paymentCompleted = paymentService.processPayment(total);

            if (!paymentCompleted) {
                throw new IllegalStateException("Payment failed");
            }

            // Step 5: Arrange shipping.
            String trackingId = shippingService.arrangeShipping( customerId, productId);

            // Step 6: Send confirmation.
            notificationService.sendConfirmation( customerId, total, trackingId);

            System.out.println("\nORDER COMPLETED SUCCESSFULLY!");

        } catch (RuntimeException exception) {

            // Release stock only if payment has not completed.
            // A real system needs a refund workflow if payment
            // succeeded but a later operation failed.
            if (stockReserved && !paymentCompleted) {
                inventoryService.releaseStock(productId, quantity);
            }

            System.out.println("\nORDER FAILED: " + exception.getMessage());
        }
    }
}

public class E_FacadeDesignPatternClient {

    public static void main(String[] args) {

        // Client knows only about the facade.
        OrderFacade orderFacade = new OrderFacade();

        // One method call triggers the complete workflow.
        orderFacade.placeOrder(1001, 101, 1);
    }
}
