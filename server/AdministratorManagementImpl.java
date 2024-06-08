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
import common.AdministratorManagement;
public class AdministratorManagementImpl extends UnicastRemoteObject implements AdministratorManagement {

    private Store store;
    protected AdministratorManagementImpl() throws RemoteException {
        super();
        this.store = Store.getInstance();
    }

    @Override
    public void addAdministrator(Administrator administrator) throws RemoteException {
        store.addAdministrator(administrator);
    }

    @Override
    public void removeAdministrator(String username) throws RemoteException {
        store.removeAdministrator(username);
    }

    @Override
    public Administrator getAdministrator(String username) throws RemoteException {
        return store.getAdministrator(username);
    }

    @Override
    public List<Administrator> getAdministrators() throws RemoteException {
        // Implementation of getAllUsers method
        return store.getAdministrators();
    }

    
    
}
