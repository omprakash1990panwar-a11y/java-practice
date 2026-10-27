package designPatterns.B_Structural;

interface PaymentService {

    public String pay(int amount, int customerId);
}

class PayPalGateway {

    public int doTransaction(double amount, int customerId) {
        // Simulate a PayPal transaction
        System.out.println("Processing PayPal transaction for customer " + customerId + " of amount $" + amount);
        return 200; // Return a success status code
    }
}

class RazerPayGateway {

    public boolean performTransaction(double amount, double customerId) {
        // Simulate a RazerPay transaction
        System.out.println("Processing RazerPay transaction for customer " + customerId + " of amount $" + amount);
        return true; // Return a success status
    }
}

class RazerPayAdapter implements PaymentService{

    RazerPayGateway razerPayGateway;

    public RazerPayAdapter(RazerPayGateway razerPayGateway) {
        this.razerPayGateway = razerPayGateway;
    }

    @Override
    public String pay(int amount, int customerId) {
        boolean result = razerPayGateway.performTransaction(Double.valueOf(amount), Double.valueOf(customerId));
        return result ? "SUCCESS" : "FAILURE";
    }
}

class PayPalAdapter implements PaymentService{

    PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public String pay(int amount, int customerId) {
        int result = payPalGateway.doTransaction(Double.valueOf(amount), Integer.valueOf(customerId));
        if (result == 200) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }
}

class PaymentClient {

    PaymentService paymentService;

    public PaymentClient(PaymentService paymentService) {
        this.paymentService =paymentService;
    }

    public void makePayment() {
        String result = paymentService.pay(500, 600);
        if(result.equals("SUCCESS")) {
            System.out.println("Payment done successful.");
        } else {
            System.out.println("Payment failed.");
        }
    }
}


public class A_AdapterDesignPatternClient {
    public static void main(String[] args) {

       new PaymentClient(new RazerPayAdapter(new RazerPayGateway())).makePayment();
       new PaymentClient(new PayPalAdapter  (new PayPalGateway())).makePayment();
    }
}
