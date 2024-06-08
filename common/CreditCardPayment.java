package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment for amount: " + amount);
        // Actual payment processing logic for credit card
    }
}