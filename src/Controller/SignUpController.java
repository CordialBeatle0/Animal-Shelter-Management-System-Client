package Controller;

import GUI.LoginGUI;
import GUI.SignUpGUI;
import RMI.AccountDTO;
import RMI.UserDTO;
import RMI.UserRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpController {
    SignUpGUI signUpGUI;
    Registry registry;

    public SignUpController(SignUpGUI signUpGUI, Registry registry) {
        this.signUpGUI = signUpGUI;
        this.registry = registry;

        signUpGUI.getjButtonCreate().addActionListener(new CreateBtnAction());
        signUpGUI.getjButtonCancel().addActionListener(new CancelBtnAction());
    }

    class CreateBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String username = signUpGUI.getjTextFieldUsername().getText();
                String password = signUpGUI.getjTextFieldPassword().getText();
                String name = signUpGUI.getjTextFieldName().getText();
                String phoneNumber = signUpGUI.getjTextFieldPhoneNumber().getText();
                String address = signUpGUI.getjComboBoxAddress().getSelectedItem().toString();
                UserRMI userRMI = (UserRMI) registry.lookup("User");
                AccountDTO accountDTO = new AccountDTO(username, password);
                UserDTO userDTO = new UserDTO(accountDTO, name, phoneNumber, address, 0);
                userRMI.signUp(userDTO);

                LoginGUI loginGUI = new LoginGUI();
                LoginController loginController = new LoginController(loginGUI, registry);
                loginGUI.setVisible(true);
                signUpGUI.dispose();
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class CancelBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginGUI loginGUI = new LoginGUI();
            LoginController loginController = new LoginController(loginGUI, registry);
            loginGUI.setVisible(true);
            signUpGUI.dispose();
        }
    }
}
