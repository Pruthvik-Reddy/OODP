package common;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Customer> customers;
    private List<Administrator> administrators;
    private List<Item> items;
    private static Store instance;
    
    private Store() {
        this.customers = new ArrayList<>();
        this.administrators = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public static synchronized Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }



    private void addInitialData() {

        //add some customers
        customers.add(new Customer("customer1","cust1_first","cust1_last","customer1","customer1","C"));
        customers.add(new Customer("customer2","cust2_first","cust2_last","customer2","customer2","C"));
        customers.add(new Customer("customer3","cust3_first","cust3_last","customer3","customer3","C"));
        customers.add(new Customer("customer4","cust4_first","cust4_last","customer4","customer4","C"));

        // Add some administrators
        administrators.add(new Administrator("admin1", "Admin1_first", "Lastname1", "admin1", "admin1","A"));
        administrators.add(new Administrator("admin2", "Admin2", "Lastname2", "admin2", "admin2","A"));

        // Add some items
        items.add(new Item("item1", "Type1", "Description1", 10.99, 50));
        items.add(new Item("item2", "Type2", "Description2", 15.99, 30));
    }


    
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void updateItem(String itemId, String key, String value) {

        Item item = findItemById(itemId);
        switch (key.toLowerCase()) {
            case "type":
                item.setType(value);
                break;
            case "description":
                item.setDescription(value);
                break;
            case "price":
                try {
                    double price = Double.parseDouble(value);
                    item.setPrice(price);
                } catch (NumberFormatException e) {
                    // Handle invalid price format
                    System.err.println("Invalid price format");
                }
                break;
            case "count":
                try {
                    int count = Integer.parseInt(value);
                    item.setCount(count);
                } catch (NumberFormatException e) {
                    // Handle invalid count format
                    System.err.println("Invalid count format");
                }
                break;
            default:
                // Handle unknown key
                System.err.println("Unknown key: " + key);
                break;
        }


    }

    

    public List<Item> getItems(){
        return items;
    }

    
    public Item findItemById(String itemId){
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }



    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }

    public void removeAdministrator(String username) {
         administrators.removeIf(administrator -> administrator.getusername().equals(username));
    }




    public Administrator getAdministrator(String username){
        for (Administrator admin : administrators) {
            if (admin.getusername().equals(username)) {
                return admin;
            }
        }
        return null;
    }


    public List<Administrator> getAdministrators(){
        return administrators;
    }

    
    public User getUser(String username){
        
        List<User> allUsers = getUsers();
        for (User user : allUsers) {
            if (user.getusername().equals(username)) {
                return user;
            }
        }
        return null;


    }

    public List<User> getUsers(){
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(customers);  // Add all customers to the list
        allUsers.addAll(administrators); // Add all administrators to the list
        return allUsers;
       
    }


  
}