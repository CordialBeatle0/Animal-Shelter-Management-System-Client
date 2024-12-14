package Controller;

import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import java.rmi.RemoteException;
import GUI.CaretakerBookDoctorAppointmentGUI;
import GUI.EmployeeViewAnimalGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RMI.AnimalDTO;
import RMI.AnimalRMI;
import RMI.AppointmentRMI;
import RMI.DoctorDTO;
import RMI.DoctorRMI;

public class CaretakerBookDoctorAppointmentController {

    CaretakerBookDoctorAppointmentGUI caretakerBookDoctorAppointmentGUI;
    Registry registry;
    AnimalRMI animalRMI;
    AnimalDTO animalDTO;
    AppointmentRMI appointmentRMI;
    DoctorDTO doctorDTO;
    DoctorRMI doctorRMI;

    public CaretakerBookDoctorAppointmentController(CaretakerBookDoctorAppointmentGUI caretakerBookDoctorAppointmentGUI,
            Registry registry) {
        this.caretakerBookDoctorAppointmentGUI = caretakerBookDoctorAppointmentGUI;
        this.registry = registry;

        try {
            animalRMI = (AnimalRMI) registry.lookup("Animal");
            appointmentRMI = (AppointmentRMI) registry.lookup("Appointment");
            doctorRMI = (DoctorRMI) registry.lookup("Doctor");
            animalDTO = animalRMI.viewAnimal(caretakerBookDoctorAppointmentGUI.getAnimalID());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // add event listeners
        caretakerBookDoctorAppointmentGUI.getjButtonBackBookDoctorAppointment()
                .addActionListener(new BackBookDocAppointmentButtonListener());
        caretakerBookDoctorAppointmentGUI.getjButtonBookAppointmentCaretakerBookAppointment()
                .addActionListener(new BookDocAppointmentButtonListener());

    }

    class BackBookDocAppointmentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAnimalGUI employeeViewAnimalGUI = new EmployeeViewAnimalGUI(
                    caretakerBookDoctorAppointmentGUI.getEmployeeDTO(),
                    caretakerBookDoctorAppointmentGUI.getAnimalID());
            employeeViewAnimalGUI.setVisible(true);
            caretakerBookDoctorAppointmentGUI.dispose();
        }
    }

    class BookDocAppointmentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String date = caretakerBookDoctorAppointmentGUI.getjTextFieldDayBookDoctorAppointment() + " / "
                    + caretakerBookDoctorAppointmentGUI.getjTextFieldMonthBookDoctorAppointment() + " / "
                    + caretakerBookDoctorAppointmentGUI.getjTextFieldYearBookDoctorAppointment();
            try {
                int selecteditem = caretakerBookDoctorAppointmentGUI.getjComboBoxAppointmentTypeBookAppointment()
                        .getSelectedIndex();

                if (selecteditem == 0) {
                    appointmentRMI.bookAppointment(1, date, doctorRMI.getDoctorByID(1), 100, " ",
                            animalRMI.viewAnimal(caretakerBookDoctorAppointmentGUI.getAnimalID()));
                } else if (selecteditem == 1) {
                    appointmentRMI.bookAppointment(1, date, doctorRMI.getDoctorByID(2), 300, " ",
                            animalRMI.viewAnimal(caretakerBookDoctorAppointmentGUI.getAnimalID()));
                } else if (selecteditem == 2) {
                    appointmentRMI.bookAppointment(1, date, doctorRMI.getDoctorByID(3), 500, " ",
                            animalRMI.viewAnimal(caretakerBookDoctorAppointmentGUI.getAnimalID()));
                } else {
                    JOptionPane.showMessageDialog(caretakerBookDoctorAppointmentGUI, "Please select all fields",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                EmployeeViewAnimalGUI employeeViewAnimalGUI = new EmployeeViewAnimalGUI(
                        caretakerBookDoctorAppointmentGUI.getEmployeeDTO(),
                        caretakerBookDoctorAppointmentGUI.getAnimalID());
                employeeViewAnimalGUI.setVisible(true);
                caretakerBookDoctorAppointmentGUI.dispose();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

}
