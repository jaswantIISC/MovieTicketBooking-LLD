package strategy.paymentMethods;

import enums.PaymentStatus;

public class CardPayment implements PaymentStrategy{

    @Override
    public PaymentStatus processPayment(double price) {
        System.out.println("Payment is done via CARD interface");
       return PaymentStatus.SUCCESS;
    }
}
