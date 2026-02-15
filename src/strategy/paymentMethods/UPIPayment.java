package strategy.paymentMethods;

import enums.PaymentStatus;

public class UPIPayment implements PaymentStrategy{

    @Override
    public PaymentStatus processPayment(double price) {
        System.out.println("Payment is done via UPI interface");
       return PaymentStatus.SUCCESS;
    }


}
