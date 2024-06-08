import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import common.Store;
import common.User;
import common.Purchase;
import common.Administrator;
import common.Customer;
import common.Item;
import common.Cart;
import server.FrontController;

/*
import server.AuthenticationImpl;
import server.AdministratorManagementImpl;
import server.ItemManagementImpl;
*/


public class clientApp {
    public static void main(String[] args) {
        try {
            // Get the registry

            // Specify the host and port number of the RMI registry
            String host = "in-csci-rrpc01.cs.iupui.edu";
            int port = 2122; 

            // Get the registry
            Registry registry = LocateRegistry.getRegistry(host, port);

            //Registry registry = LocateRegistry.getRegistry("in-csci-rrpc01.cs.iupui.edu");


            /*
            AuthenticationImpl AuthenticationManager = (AuthenticationImpl) registry.lookup("AuthenticationManager");
            ItemManagementImpl ItemManager = (ItemManagementImpl) registry.lookup("ItemManager");
            AdministratorManagementImpl AdministrationManager = (AdministratorManagementImpl) registry.lookup("AdministrationManager");
            */

            FrontController frontController = (FrontController) registry.lookup("FrontController");
            
            
            
            Scanner scanner = new Scanner(System.in);

            // Authenticate the user
            System.out.println("Please enter your username:");
            String username = scanner.nextLine();
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            /*
            String role = AuthenticationManager.authenticate(username, password);
            */

            String role = frontController.processRequest(username, password);
            

            if (role.equals("not_found")) {
                System.out.println("Invalid username or password.");
                return;
            }

            // Display the appropriate menu based on the user's role
            if (role.equals("C")) {
                //displayCustomerMenu(scanner, ItemManager);
                displayCustomerMenu(scanner, frontController);
            } else if (role.equals("A")) {
                displayAdministratorMenu(scanner);
            }

            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*

    private static void displayCustomerMenu(Scanner scanner, ItemManagementImpl itemManagement) throws Exception {
        System.out.println("Welcome, Customer!");
        System.out.println("Available items in the store:");

        List<Item> items = itemManagement.getAllItems();
        for (Item item : items) {
            System.out.println(item);
        }
    }

*/

    private static void displayCustomerMenu(Scanner scanner, FrontController frontController) throws Exception {
        System.out.println("Welcome, Customer!");
        System.out.println("Available items in the store:");

        List<Item> items = frontController.getAllItems();
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private static void displayAdministratorMenu(Scanner scanner) {
        // Implement administrator menu options here
        System.out.println("Welcome, Administrator!");
        
    }
}
