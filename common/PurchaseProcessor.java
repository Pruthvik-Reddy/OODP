package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class PurchaseProcessor {
    
    // Template method defining the common workflow
    public final void processPurchase() {
        selectItems();
        calculateTotal();
        applyDiscount();
        processPayment();
        deliverItems();
    }
    
    // Abstract methods to be implemented by subclasses
    protected abstract void selectItems();
    protected abstract void calculateTotal();
    protected abstract void applyDiscount();
    protected abstract void processPayment();
    protected abstract void deliverItems();
}