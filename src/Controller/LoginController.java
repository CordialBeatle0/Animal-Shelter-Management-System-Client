package Controller;

import GUI.AdminDashboardGUI;
import GUI.CaretakerDashboardGUI;
import GUI.CourierDashboardGUI;
import GUI.LoginGUI;
import GUI.SignUpGUI;
import GUI.DoctorDashboardGUI;
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

import javax.print.Doc;

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
                    UserDTO userDTO = accountRMI.userLogin(loginGUI.getjTextFieldUsername().getText(),
                            loginGUI.getjTextFieldPassword().getText());

                    UserDashboardGUI userDashboardGUI = new UserDashboardGUI(userDTO);
                    UserDashboardController userDashboardController = new UserDashboardController(userDashboardGUI,
                            registry);
                    userDashboardGUI.setVisible(true);
                    loginGUI.dispose();
                } else if (loginGUI.getjRadioButtonEmployee().isSelected()) {
                    AccountRMI accountRMI = (AccountRMI) registry.lookup("Account");
                    EmployeeDTO employeeDTO = accountRMI.empLogin(loginGUI.getjTextFieldUsername().getText(),
                            loginGUI.getjTextFieldPassword().getText());
                    System.out.println(loginGUI.getjTextFieldUsername().getText());
                    System.out.println(loginGUI.getjTextFieldPassword().getText());
                    // TODO: Add code to open the employee's account
                    switch (employeeDTO.getType()) {
                        case "Admin":
                            AdminDTO adminDTO = new AdminDTO(employeeDTO.getName(), employeeDTO.getAge(),
                                    employeeDTO.getGender(), employeeDTO.getEmail(), employeeDTO.getPhoneNumber(),
                                    employeeDTO.getAddress(), employeeDTO.getUsername(), employeeDTO.getPassword(),
                                    employeeDTO.getSalary(), employeeDTO.getType());
                            AdminDashboardGUI adminDashboardGUI = new AdminDashboardGUI(adminDTO);
                            AdminDashboardController adminDashboardController = new AdminDashboardController(
                                    adminDashboardGUI, registry);
                            adminDashboardGUI.setVisible(true);
                            loginGUI.dispose();
                            break;
                        case "Doctor":
                            DoctorDTO doctorDTO = new DoctorDTO(employeeDTO.getID(), employeeDTO.getName(),
                                    employeeDTO.getAge(), employeeDTO.getGender(), employeeDTO.getEmail(), employeeDTO.getPhoneNumber(),
                                    employeeDTO.getAddress(), employeeDTO.getUsername(), employeeDTO.getPassword(),
                                    employeeDTO.getSalary(), "Doctor");
                            DoctorDashboardGUI doctorDashboardGUI = new DoctorDashboardGUI(doctorDTO);
                            DoctorDashboardController doctorDashboardController = new DoctorDashboardController(
                                    doctorDashboardGUI, registry);
                            doctorDashboardGUI.setVisible(true);
                            loginGUI.dispose();
                            break;
                        case "Courier":
                            CourierDTO courierDTO = new CourierDTO(employeeDTO.getID(), employeeDTO.getName(),
                                    employeeDTO.getAge(), employeeDTO.getGender(), employeeDTO.getEmail(), employeeDTO.getPhoneNumber(),
                                    employeeDTO.getAddress(), employeeDTO.getUsername(), employeeDTO.getPassword(),
                                    employeeDTO.getSalary(), "Courier", null, 5);
                            CourierDashboardGUI courierDashboardGUI = new CourierDashboardGUI(courierDTO);
                            CourierDashboardController courierDashboardController = new CourierDashboardController(
                                    courierDashboardGUI, registry);
                            courierDashboardGUI.setVisible(true);
                            loginGUI.dispose();
                            break;
                        case "Caretaker":
                            CaretakerDTO caretakerDTO = new CaretakerDTO(employeeDTO.getName(), employeeDTO.getAge(),
                                    employeeDTO.getGender(), employeeDTO.getEmail(), employeeDTO.getPhoneNumber(),
                                    employeeDTO.getAddress(), employeeDTO.getUsername(), employeeDTO.getPassword(),
                                    employeeDTO.getSalary(), employeeDTO.getType(), null);
                            CaretakerDashboardGUI caretakerDashboardGUI = new CaretakerDashboardGUI(caretakerDTO);
                            CaretakerDashboardController caretakerDashboardController = new CaretakerDashboardController(
                                    caretakerDashboardGUI, registry);
                            caretakerDashboardGUI.setVisible(true);
                            caretakerDashboardGUI.setLocationRelativeTo(null);
                            loginGUI.dispose();
                            break;
                    }

                } else if (loginGUI.getjRadioButtonVolunteer().isSelected()) {
                    AccountRMI accountRMI = (AccountRMI) registry.lookup("Account");
                    VolunteerDTO volunteerDTO = accountRMI.volunteerLogin(loginGUI.getjTextFieldUsername().getText(),
                            loginGUI.getjTextFieldPassword().getText());
                    VolunteerDashboardGUI volunteerDashboardGUI = new VolunteerDashboardGUI(volunteerDTO);
                    VolunteerDashboardContoller volunteerDashboardContoller = new VolunteerDashboardContoller(
                            volunteerDashboardGUI, registry);
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
            SignUpController signUpController = new SignUpController(signUp, registry);
            signUp.setVisible(true);
            loginGUI.dispose();
        }
    }
}