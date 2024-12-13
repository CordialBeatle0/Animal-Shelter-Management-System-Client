package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserRMI extends Remote {
    void signUp(UserDTO user) throws RemoteException;
}
