package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ItemManagement extends Remote {
    void addItem(Item item) throws RemoteException;
    void removeItem(String itemId) throws RemoteException;
    void updateItem(String itemId,String key, String value) throws RemoteException;
    Item findItemById(String itemId) throws RemoteException;
    List<Item> getAllItems() throws RemoteException;
    // Other methods related to item management
}