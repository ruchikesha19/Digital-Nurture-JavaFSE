interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1
class PayTMGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through PayTM.");
    }
}

// Adaptee 2
class GooglePayGateway {
    public void sendPayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through Google Pay.");
    }
}

// Adapter for PayTM
class PayTMAdapter implements PaymentProcessor {

    private PayTMGateway payTMGateway;

    public PayTMAdapter(PayTMGateway payTMGateway) {
        this.payTMGateway = payTMGateway;
    }

    @Override
    public void processPayment(double amount) {
        payTMGateway.makePayment(amount);
    }
}

// Adapter for Google Pay
class GooglePayAdapter implements PaymentProcessor {

    private GooglePayGateway googlePayGateway;

    public GooglePayAdapter(GooglePayGateway googlePayGateway) {
        this.googlePayGateway = googlePayGateway;
    }

    @Override
    public void processPayment(double amount) {
        googlePayGateway.sendPayment(amount);
    }
}

public class AdapterPattern {

    public static void main(String[] args) {

        PaymentProcessor payTM =
                new PayTMAdapter(new PayTMGateway());

        PaymentProcessor googlePay =
                new GooglePayAdapter(new GooglePayGateway());

        payTM.processPayment(5000);

        googlePay.processPayment(2500);
    }
}