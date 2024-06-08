package common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import common.Administrator;

public interface AdministratorManagement extends Remote {
    void addAdministrator(Administrator Administrator) throws RemoteException;
    void removeAdministrator(String username) throws RemoteException;
    Administrator getAdministrator(String username) throws RemoteException;
    List<Administrator> getAdministrators() throws RemoteException;
    
}