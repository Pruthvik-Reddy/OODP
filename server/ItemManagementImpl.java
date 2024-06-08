package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import common.Store;
import common.User;
import common.Purchase;
import common.Administrator;
import common.Customer;
import common.Item;
import common.Cart;
import common.ItemManagement;
public class ItemManagementImpl extends UnicastRemoteObject implements ItemManagement {

    private Store store;

    protected ItemManagementImpl() throws RemoteException {
        super();
        this.store = Store.getInstance();
    }

    @Override
    public void addItem(Item item) throws RemoteException {
        store.addItem(item);
    }

    @Override
    public void removeItem(String itemId) throws RemoteException {
        Item item = store.findItemById(itemId);
        store.removeItem(item);
    }


    @Override
    public void updateItem(String itemId, String key, String value) throws RemoteException {
        //item = store.findItemById(itemId);
        store.updateItem(itemId, key, value);
    }

    @Override
    public Item findItemById(String itemId) throws RemoteException {
        // Implementation of getItem method
        Item item = store.findItemById(itemId);
        return item;
    }


    @Override
    public List<Item> getAllItems() throws RemoteException {
        // Implementation of getAllItems method
        List<Item> items = store.getItems();
        return items;
    }


}