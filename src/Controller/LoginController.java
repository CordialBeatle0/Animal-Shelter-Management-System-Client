package Controller;

import GUI.AdminDashboardGUI;
import GUI.LoginGUI;
import GUI.SignUpGUI;
import GUI.UserDashboardGUI;
import GUI.VolunteerDashboardGUI;
import RMI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    LoginGUI loginGUI;
    Registry registry;
    
    public LoginController(LoginGUI loginGUI, Registry registry) {
        this.loginGUI = loginGUI;
        this.registry = registry;
        
        // TODO: Add action listeners to the loginGUI
        loginGUI.getjButtonLogin().addActionListener(new LoginBtnAction());
        loginGUI.getjButtonSignUp().addActionListener(new SignUpBtnAction());
    }
    
    class LoginBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (loginGUI.getjRadioButtonUser().isSelected()) {
                    AccountRMI accountRMI = (AccountRMI) registry.lookup("Account");
                    UserDTO userDTO = accountRMI.userLogin(loginGUI.getjTextFieldUsername().getText(), loginGUI.getjTextFieldPassword().getText());
                    
                    UserDashboardGUI userDashboardGUI = new UserDashboardGUI(userDTO);
                    userDashboardGUI.setVisible(true);
                    loginGUI.dispose();
                } else if (loginGUI.getjRadioButtonEmployee().isSelected()) {
                    AccountRMI accountRMI = (AccountRMI) registry.lookup("Account");
                    EmployeeDTO employeeDTO = accountRMI.empLogin(loginGUI.getjTextFieldUsername().getText(), loginGUI.getjTextFieldPassword().getText());
                    // TODO: Add code to open the employee's account
                    switch (employeeDTO.getClass().getName()) {
                        case "Admin":
                            AdminDTO adminDTO = (AdminDTO) employeeDTO;
                            AdminDashboardGUI adminDashboardGUI = new AdminDashboardGUI(adminDTO);
                            adminDashboardGUI.setVisible(true);
                            loginGUI.dispose();
                            break;
                        case "Doctor":
                            DoctorDTO doctorDTO = (DoctorDTO) employeeDTO;
                            // TODO: add the DoctorGUI
                            break;
                        case "Courier":
                            CourierDTO courierDTO = (CourierDTO) employeeDTO;
                            // TODO: add the CourierGUI
                            break;
                        case "Caretaker":
                            CaretakerDTO caretakerDTO = (CaretakerDTO) employeeDTO;
                            // TODO: add the CaretakerGUI
                            break;
                    }
                    
                } else if (loginGUI.getjRadioButtonVolunteer().isSelected()) {
                    AccountRMI accountRMI = (AccountRMI) registry.lookup("Account");
                    VolunteerDTO volunteerDTO = accountRMI.volunteerLogin(loginGUI.getjTextFieldUsername().getText(), loginGUI.getjTextFieldPassword().getText());
                    VolunteerDashboardGUI volunteerDashboardGUI = new VolunteerDashboardGUI(volunteerDTO);
                    volunteerDashboardGUI.setVisible(true);
                    loginGUI.dispose();
                }
                
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    class SignUpBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignUpGUI signUp = new SignUpGUI();
            signUp.setVisible(true);
            loginGUI.dispose();
        }
    }
}