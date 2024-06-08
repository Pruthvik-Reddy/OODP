package common;

import java.io.Serializable;
import java.util.List;

public class Purchase implements Serializable {
    private List<Item> purchasedItems;

    public Purchase(List<Item> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public double purchase_bill() {
        double totalbill = 0.0;
        for (Item item : purchasedItems) {
            totalbill += item.getPrice();
        }
        return totalbill;
    }

}