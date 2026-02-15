package strategy.paymentMethods;

import enums.PaymentStatus;

public class InvalidCardPayment implements PaymentStrategy{

    @Override
    public PaymentStatus processPayment(double price) {
        System.out.println("Payment is done via INVALID CARD interface");
       return PaymentStatus.FAILED;
    }
}
