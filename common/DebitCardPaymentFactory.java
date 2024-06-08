package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class DebitCardPaymentFactory implements PaymentMethodFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new DebitCardPayment();
    }
}