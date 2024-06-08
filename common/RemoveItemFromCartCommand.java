package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class RemoveItemFromCartCommand implements Command {
    private Cart cart;
    private Item item;

    public RemoveItemFromCartCommand(Cart cart, Item item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {
        cart.removeItem(item);
    }
}