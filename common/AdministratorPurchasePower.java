package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdministratorPurchaseProcessor extends PurchaseProcessor {

    @Override
    protected void selectItems() {
        // Implementation specific to administrators
    }

    @Override
    protected void calculateTotal() {
        // Implementation specific to administrators
    }

    @Override
    protected void applyDiscount() {
        // Implementation specific to administrators
    }

    @Override
    protected void processPayment() {
        // Implementation specific to administrators
    }

    @Override
    protected void deliverItems() {
        // Implementation specific to administrators
    }
}