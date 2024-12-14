package Controller;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import GUI.ManageAccountGUI;
import RMI.AccountRMI;
import RMI.EmployeeDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   

public class ManagAccountController {

    ManageAccountGUI manageAccountGUI;
    Registry registry;
    AccountRMI accountRMI;

    public ManagAccountController(ManageAccountGUI manageAccountGUI, Registry registry) {
        this.manageAccountGUI = manageAccountGUI;
        this.registry = registry;
        try {
            accountRMI = (AccountRMI) registry.lookup("Account");
            uploadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        manageAccountGUI.getjButton1UpdateAccount().addActionListener(new updateButtonListener());

    }
    
    private void uploadData() {
        if (manageAccountGUI.getEmployeeDTO().getClass().equals("CaretakerDTO")
                || manageAccountGUI.getEmployeeDTO().getClass().equals("AdminDTO")) {
            manageAccountGUI.getjTextFieldUserName()
                    .setText(manageAccountGUI.getEmployeeDTO().getAccount().getUsername());
            manageAccountGUI.getjTextFieldPassword()
                    .setText(manageAccountGUI.getEmployeeDTO().getAccount().getPassword());

        }
        else if (manageAccountGUI.getUserDTO().getClass().equals("UserDTO")) {
            manageAccountGUI.getjTextFieldUserName().setText(manageAccountGUI.getUserDTO().getAccount().getUsername());
            manageAccountGUI.getjTextFieldPassword().setText(manageAccountGUI.getUserDTO().getAccount().getPassword());
        }   
    }

    class updateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)  {

            if (manageAccountGUI.getEmployeeDTO().getClass().equals("CaretakerDTO")
                    || manageAccountGUI.getEmployeeDTO().getClass().equals("AdminDTO")) {
                try {
                    accountRMI.updateSpecialisedAccount(manageAccountGUI.getEmployeeDTO().getID(),
                            manageAccountGUI.getEmployeeDTO().getAccount().getUsername(),
                            manageAccountGUI.getEmployeeDTO().getAccount().getPassword());
                } catch (RemoteException e1) {
                    e1.printStackTrace();

                }

            }
            else if (manageAccountGUI.getUserDTO().getClass().equals("UserDTO")) {
                try {
                    accountRMI.updateUserAccount(manageAccountGUI.getUserDTO(),
                            manageAccountGUI.getUserDTO().getAccount().getUsername(),
                              manageAccountGUI.getUserDTO().getAccount().getPassword());
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }
}
