package strategy.paymentMethods;

import enums.PaymentStatus;

public interface PaymentStrategy {
    public PaymentStatus processPayment(double price);  
} 