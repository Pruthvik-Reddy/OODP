package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public interface PaymentMethodFactory {
    PaymentMethod createPaymentMethod();
}