package Controller;

import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import GUI.CaretakerBookDoctorAppointmentGUI;
import GUI.EmployeeViewAnimalGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RMI.AnimalDTO;
import RMI.AnimalRMI;

public class CaretakerBookDoctorAppointmentController {

    CaretakerBookDoctorAppointmentGUI caretakerBookDoctorAppointmentGUI;
    Registry registry;
    AnimalRMI animalRMI;
    AnimalDTO animalDTO;

    public CaretakerBookDoctorAppointmentController(CaretakerBookDoctorAppointmentGUI caretakerBookDoctorAppointmentGUI,
            Registry registry) {
        this.caretakerBookDoctorAppointmentGUI = caretakerBookDoctorAppointmentGUI;
        this.registry = registry;

        try {
            animalRMI = (AnimalRMI) registry.lookup("Animal");
            animalDTO = animalRMI.viewAnimal(caretakerBookDoctorAppointmentGUI.getAnimalID());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    
    //todo: implement the book appointment actually 
   
}
