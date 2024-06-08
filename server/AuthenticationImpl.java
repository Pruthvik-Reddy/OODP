
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
public class AuthenticationImpl extends UnicastRemoteObject {
    
    private Store store;


    public AuthenticationImpl() throws RemoteException {
        super();
        this.store = store;
    }

    public String authenticate(String username, String password) throws RemoteException {
        List<User> users = store.getUsers();
        for (User user : users) {
            if (user.getusername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User found Loggin in");
                System.out.println(user.getRole());
                
                return user.getRole();
            }
        }
        return "not_found";
    }

    public boolean register( String userID,  String firstName, String lastName, String username, String password, String role) throws RemoteException {
        List<User> users = store.getUsers();
        for (User user : users) {
            if (user.getusername().equals(username)) {
                System.out.println("Username already exists. Retry password");
                return false; // Username already exists
            }
        }
        


        if (role.equals("C")) {
            Customer newCustomer = new Customer(userID, firstName, lastName, username, password, role);
            users.add(newCustomer);
        } 


        return true; 
    }

}