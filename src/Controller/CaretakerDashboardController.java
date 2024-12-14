package Controller;

import java.rmi.registry.Registry;

import GUI.CaretakerDashboardGUI;
import GUI.CaretakerRegisterAnimalGUI;
import GUI.EmployeeViewAllAnimalsGUI;
import GUI.EmployeeViewBookedVisitsGUI;
import GUI.EmployeeViewAllVideosGUI;
import GUI.LoginGUI;
import GUI.ManageAccountGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaretakerDashboardController {
    CaretakerDashboardGUI caretakerDashboardGUI;
    Registry registry;


    public CaretakerDashboardController(CaretakerDashboardGUI caretakerDashboardGUI, Registry registry) {
        this.caretakerDashboardGUI = caretakerDashboardGUI;
        this.registry = registry;

        caretakerDashboardGUI.getjButtonLogoutCaretakerDashboard().addActionListener(new LogoutButtonListener());
        caretakerDashboardGUI.getjButtonManageAccountCaretakerDashboard().addActionListener(new ManageAccountButtonListener());
        caretakerDashboardGUI.getjButtonRegisterAnimalCaretakerDashboard();
        caretakerDashboardGUI.getjButtonViewAllAnimalsCaretakerDashboard().addActionListener(new ViewAllAnimalsButtonListener());
        caretakerDashboardGUI.getjButtonViewAllBookedVisitsCaretakerDashboard();
        caretakerDashboardGUI.getjButtonViewAllVideosCaretakerDashboard().addActionListener(new ViewAllVideosButtonListener());
                 
        

    }

    class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginGUI loginGUI = new LoginGUI();
            LoginController loginController = new LoginController(loginGUI, registry);
            loginGUI.setVisible(true);
            caretakerDashboardGUI.dispose();
        }
    }
    
    class ManageAccountButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO: use the constructor that takes the caretaketdto as a parameter
            ManageAccountGUI manageAccountGUI = new ManageAccountGUI();
            
            manageAccountGUI.setVisible(true);
            caretakerDashboardGUI.dispose();
        }
    }

    class RegisterAnimalButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerRegisterAnimalGUI caretakerRegisterAnimalGUI = new CaretakerRegisterAnimalGUI(caretakerDashboardGUI.getCaretakerDTO());
            caretakerRegisterAnimalGUI.setVisible(true);
            caretakerDashboardGUI.dispose();
        }
    }

    class ViewAllAnimalsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAllAnimalsGUI employeeViewAllAnimalsGUI = new EmployeeViewAllAnimalsGUI(
                    caretakerDashboardGUI.getEmployeeDTO());
            employeeViewAllAnimalsGUI.setVisible(true);
            caretakerDashboardGUI.dispose();
        }
    }
    
    class ViewAllBookedVisitsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewBookedVisitsGUI employeeViewBookedVisitsGUI = new EmployeeViewBookedVisitsGUI(caretakerDashboardGUI.getEmployeeDTO());
            employeeViewBookedVisitsGUI.setVisible(true);
            caretakerDashboardGUI.dispose();
        }
    }

    class ViewAllVideosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAllVideosGUI employeeViewAllVideosGUI = new EmployeeViewAllVideosGUI(caretakerDashboardGUI.getEmployeeDTO());
            employeeViewAllVideosGUI.setVisible(true);
            caretakerDashboardGUI.dispose();
        }
    }


}
