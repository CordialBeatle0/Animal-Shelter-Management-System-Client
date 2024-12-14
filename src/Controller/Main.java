package Controller;

import GUI.LoginGUI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        LoginGUI loginGUI = new LoginGUI();Registry registry;
        try {
            registry = LocateRegistry.getRegistry(1099);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        LoginController loginController = new LoginController(loginGUI, registry);
        loginGUI.setVisible(true);
    }
}
