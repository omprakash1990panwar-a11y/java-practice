
package designPatterns.C_Behavioural;

import java.util.ArrayList;
import java.util.List;

// Defines the common contract for all interceptors.
interface Interceptor {
    boolean execute(Order order);
}

// Holds the data that must be validated.
class Order {
    private final String name;
    private final String contact;
    private final String address;
    private final double deposit;
    private final String orderDetails;

    public Order(String name, String contact, String address,
                 double deposit, String orderDetails) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.deposit = deposit;
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public double getDeposit() {
        return deposit;
    }

    public String getOrderDetails() {
        return orderDetails;
    }
}

// Validates the customer's name.
class NameInterceptor implements Interceptor {
    @Override
    public boolean execute(Order order) {
        String name = order.getName();

        boolean valid = name != null
                && name.matches("[\\p{L}]+(?:[ '\\-][\\p{L}]+)*");

        System.out.println("Name validation: " + (valid ? "PASS" : "FAIL"));

        return valid;
    }
}

// Validates the contact number.
class ContactInterceptor implements Interceptor {
    @Override
    public boolean execute(Order order) {
        String contact = order.getContact();

        boolean valid = contact != null
                && contact.matches("\\d{10}");

        System.out.println("Contact validation: "
                + (valid ? "PASS" : "FAIL"));

        return valid;
    }
}

// Validates the customer's address.
class AddressInterceptor implements Interceptor {
    @Override
    public boolean execute(Order order) {
        String address = order.getAddress();

        boolean valid = address != null && !address.isBlank();

        System.out.println("Address validation: "
                + (valid ? "PASS" : "FAIL"));

        return valid;
    }
}

// Validates the deposit amount.
class DepositInterceptor implements Interceptor {
    @Override
    public boolean execute(Order order) {
        boolean valid = Double.isFinite(order.getDeposit())
                && order.getDeposit() >= 0;

        System.out.println("Deposit validation: " + (valid ? "PASS" : "FAIL"));

        return valid;
    }
}

// Validates the order details.
class OrderInterceptor implements Interceptor {
    @Override
    public boolean execute(Order order) {
        String details = order.getOrderDetails();

        boolean valid = details != null && !details.isBlank();

        System.out.println("Order validation: "
                + (valid ? "PASS" : "FAIL"));

        return valid;
    }
}

// Runs registered interceptors in sequence.
class InterceptorManager {
    private final List<Interceptor> interceptors = new ArrayList<>();

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public boolean executeInterceptors(Order order) {
        for (Interceptor interceptor : interceptors) {
            // Stop processing as soon as a validation fails.
            if (!interceptor.execute(order)) {
                return false;
            }
        }

        return true;
    }
}

// Processes the request after all interceptors succeed.
class OrderHandler {
    public void process(Order order) {
        System.out.println("Order processed successfully: "
                + order.getOrderDetails());
    }
}

// Client configures the interceptors and submits a request.
public class J_Interceptor {
    public static void main(String[] args) {
        InterceptorManager manager = new InterceptorManager();

        manager.addInterceptor(new NameInterceptor());
        manager.addInterceptor(new ContactInterceptor());
        manager.addInterceptor(new AddressInterceptor());
        manager.addInterceptor(new DepositInterceptor());
        manager.addInterceptor(new OrderInterceptor());

        Order order = new Order(
                "Om Prakash",
                "9876543210",
                "Jaipur, Rajasthan",
                500.0,
                "Laptop purchase"
        );

        if (manager.executeInterceptors(order)) {
                    new OrderHandler().process(order);

        } else {
            System.out.println("Request rejected due to validation failure.");
        }
    }
}
