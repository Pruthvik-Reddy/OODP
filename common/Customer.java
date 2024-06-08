package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private Cart cart;
    private List<Purchase> purchaseHistory;

    public Customer(String userID, String firstName, String lastName, String username, String password,String role) {
        super(userID, firstName, lastName, username, password, role);
        this.cart = new Cart();
        this.purchaseHistory = new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


    public void addItemToCart(Item item) {
        cart.addItem(item);
    }

    public void removeItemFromCart(Item item) {
        cart.removeItem(item);
    }

    public void makePurchase() {
        if (!cart.getItems().isEmpty()) {
            Purchase purchase = new Purchase(new ArrayList<>(cart.getItems()));
            purchaseHistory.add(purchase);
            cart.getItems().clear();
        }
    }

}