package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class AddItemToCartCommand implements Command {
    private Cart cart;
    private Item item;

    public AddItemToCartCommand(Cart cart, Item item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {
        cart.addItem(item);
    }
}