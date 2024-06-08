package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.Command;
import common.AddItemToCartCommand;
import common.RemoveItemFromCartCommand;
import common.PaymentMethodFactory;
import common.DebitCardPaymentFactory;
import common.CreditCardPaymentFactory;
import common.PaymentMethod;
import common.DebitCardPayment;
import common.CreditCardPayment;
import common.Store;
import common.User;
import common.Purchase;
import common.Administrator;
import common.Customer;
import common.Item;
import common.Cart;
import common.AdministratorManagement;


public class FrontController extends UnicastRemoteObject {

    private AuthenticationImpl authenticationManager;
    private ItemManagementImpl itemManager;
    private AdministratorManagementImpl administrationManager;
    private Map<String, Command> commandMap;
    private PaymentMethodFactory paymentMethodFactory;


    public FrontController() throws RemoteException {
        super();
        this.authenticationManager = new AuthenticationImpl();
        this.itemManager = new ItemManagementImpl();
        this.administrationManager = new AdministratorManagementImpl();
         this.paymentMethodFactory = paymentMethodFactory;

        commandMap = new HashMap<>();
        // Initialize command mappings
        commandMap.put("ADD_ITEM", new AddItemToCartCommand());
        commandMap.put("REMOVE_ITEM", new RemoveItemFromCartCommand());

    }

    public String processRequest(String username, String password) throws RemoteException {
        return authenticationManager.authenticate(username, password);
    }

    public boolean registerUser(String userID, String firstName, String lastName, String username, String password, String role) throws RemoteException {
        return authenticationManager.register(userID, firstName, lastName, username, password, role);
    }

    public void addItem(Item item) throws RemoteException {
        itemManager.addItem(item);
    }

    public void removeItem(String itemId) throws RemoteException {
        itemManager.removeItem(itemId);
    }

    public void updateItem(String itemId, String key, String value) throws RemoteException {
        itemManager.updateItem(itemId, key, value);
    }

    public Item findItemById(String itemId) throws RemoteException {
        return itemManager.findItemById(itemId);
    }

    public List<Item> getAllItems() throws RemoteException {
        return itemManager.getAllItems();
    }

    public void addAdministrator(Administrator administrator) throws RemoteException {
        administrationManager.addAdministrator(administrator);
    }

    public void removeAdministrator(String username) throws RemoteException {
        administrationManager.removeAdministrator(username);
    }

    public Administrator getAdministrator(String username) throws RemoteException {
        return administrationManager.getAdministrator(username);
    }

    public List<Administrator> getAdministrators() throws RemoteException {
        return administrationManager.getAdministrators();
    }


    public void editCartRequest(String commandName) throws RemoteException {
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command: " + commandName);
        }
    }


    public void processPayment(double amount, String paymentType) {
        PaymentMethod paymentMethod = paymentMethodFactory.createPaymentMethod(paymentType);
        paymentMethod.processPayment(amount);
    }

}