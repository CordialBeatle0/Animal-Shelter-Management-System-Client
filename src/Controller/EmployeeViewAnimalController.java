package Controller;

import java.rmi.registry.Registry;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import GUI.CaretakerBookDoctorAppointmentGUI;
import GUI.EmployeeViewAllAnimalsGUI;
import GUI.EmployeeViewAnimalGUI;
import RMI.AnimalDTO;
import RMI.AnimalRMI;

public class EmployeeViewAnimalController {

    EmployeeViewAnimalGUI employeeViewAnimalGUI;
    Registry registry;
    AnimalRMI animalRMI;
    AnimalDTO animalDTO;
    JTable jTableEmployeeViewAllAnimals;
    DefaultTableModel tableModel;

    public EmployeeViewAnimalController(EmployeeViewAnimalGUI employeeViewAnimalGUI, Registry registry) {
        this.employeeViewAnimalGUI = employeeViewAnimalGUI;
        this.registry = registry;
        jTableEmployeeViewAllAnimals = employeeViewAnimalGUI.getjTableAnimalDetailsViewAnimal();
        tableModel = (DefaultTableModel) jTableEmployeeViewAllAnimals.getModel();
        try {
            animalRMI = (AnimalRMI) registry.lookup("Animal");
            animalDTO = animalRMI.viewAnimal(employeeViewAnimalGUI.getAnimalID());
            loadData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        employeeViewAnimalGUI.getjButtonBackViewAnimalGUI().addActionListener(new BackViewAllAnimalsButtonListener());
        employeeViewAnimalGUI.getjButtonRecordFeedingViewAnimal().addActionListener(new RecordFeedingButtonListener());
        employeeViewAnimalGUI.getjButtonBookDoctorAppointmentViewAnimal()
                .addActionListener(new BookDocAppointmentButtonListener());

    }

    // TODO: recheck this because it's not clear what it does
    private void loadData() {
        employeeViewAnimalGUI.getjTextFieldAnimalNameViewAnimalGUI().setText(animalDTO.getName());

        int columns = 1;
        int rows = 0;

        tableModel.addRow(new Object[0]);
        jTableEmployeeViewAllAnimals.setValueAt(animalDTO.getID(), rows++, columns);
        jTableEmployeeViewAllAnimals.setValueAt(animalDTO.getName(), rows++, columns);
        jTableEmployeeViewAllAnimals.setValueAt(animalDTO.getAnimalType(), rows++, columns);
        jTableEmployeeViewAllAnimals.setValueAt(animalDTO.getBreed(), rows++, columns);
        jTableEmployeeViewAllAnimals.setValueAt(animalDTO.getAge(), rows++, columns);

    }

    class BackViewAllAnimalsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAllAnimalsGUI employeeViewAllAnimalsGUI = new EmployeeViewAllAnimalsGUI(
                    employeeViewAnimalGUI.getEmployeeDTO());
            EmployeeViewAllAnimalsController employeeViewAllAnimalsController = new EmployeeViewAllAnimalsController(
                    employeeViewAllAnimalsGUI, registry);
            employeeViewAllAnimalsGUI.setVisible(true);
            employeeViewAnimalGUI.dispose();

        }

    }

    class RecordFeedingButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                animalRMI.recordFeeding(animalDTO);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

        }

    }

    class BookDocAppointmentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerBookDoctorAppointmentGUI caretakerBookDoctorAppointment = new CaretakerBookDoctorAppointmentGUI(
                    employeeViewAnimalGUI.getEmployeeDTO(), employeeViewAnimalGUI.getAnimalID());
            CaretakerBookDoctorAppointmentController caretakerBookDoctorAppointmentController = new CaretakerBookDoctorAppointmentController(
                    caretakerBookDoctorAppointment, registry);
            caretakerBookDoctorAppointment.setVisible(true);
            employeeViewAnimalGUI.dispose();

        }

    }

}