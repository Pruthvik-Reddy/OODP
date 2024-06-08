package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class DebitCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment for amount: " + amount);
        // Actual payment processing logic for debit card
    }
}
