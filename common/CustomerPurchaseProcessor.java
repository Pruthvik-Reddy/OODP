
package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerPurchaseProcessor extends PurchaseProcessor {

    @Override
    protected void selectItems() {
        // Implementation specific to customers
    }

    @Override
    protected void calculateTotal() {
        // Implementation specific to customers
    }

    @Override
    protected void applyDiscount() {
        // Implementation specific to customers
    }

    @Override
    protected void processPayment() {
        // Implementation specific to customers
    }

    @Override
    protected void deliverItems() {
        // Implementation specific to customers
    }
}
