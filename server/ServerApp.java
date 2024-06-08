package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import common.Store;
import common.User;
import common.Customer;
import common.Administrator;
import server.AuthenticationImpl;
import server.ItemManagementImpl;
import server.AdministratorManagementImpl;


public class ServerApp {
    public static void main(String[] args) {
        
        try {
            LocateRegistry.createRegistry(2122);
            
            FrontController frontController = new FrontController();
            Naming.rebind("FrontController", frontController);
            /*
            AuthenticationImpl AuthenticationManager = new AuthenticationImpl();
            AdministratorManagementImpl AdministrationManager = new AdministratorManagementImpl();
            ItemManagementImpl ItemManager = new ItemManagementImpl();
            Naming.rebind("AuthenticationManager", AuthenticationManager);
            Naming.rebind("AdministrationManager", AdministrationManager);
            Naming.rebind("ItemManager", ItemManager);
            */
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}