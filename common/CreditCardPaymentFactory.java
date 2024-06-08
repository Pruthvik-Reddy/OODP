package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class CreditCardPaymentFactory implements PaymentMethodFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}