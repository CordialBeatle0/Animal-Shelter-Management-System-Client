package Controller;

import GUI.CaretakerDashboardGUI;
import GUI.EmployeeViewAllAnimalsGUI;
import GUI.EmployeeViewAnimalGUI;
import RMI.AnimalRMI;
import RMI.AnimalDTO;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeViewAllAnimalsController {
    EmployeeViewAllAnimalsGUI employeeViewAllAnimalsGUI;
    Registry registry;
    JTable jTableEmployeeViewAllAnimals;
    DefaultTableModel tableModel;
    AnimalRMI animalRMI;

    public EmployeeViewAllAnimalsController(EmployeeViewAllAnimalsGUI employeeViewAllAnimalsGUI, Registry registry) {
        this.employeeViewAllAnimalsGUI = employeeViewAllAnimalsGUI;
        this.registry = registry;
        jTableEmployeeViewAllAnimals = employeeViewAllAnimalsGUI.getjTableAllAnimalsViewAllAnimals();
        tableModel = (DefaultTableModel) jTableEmployeeViewAllAnimals.getModel();
        try{

            animalRMI = (AnimalRMI) registry.lookup("Animal");
            loadTable();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        employeeViewAllAnimalsGUI.getjButtonViewAnimalViewAllAnimals()
                .addActionListener(new ViewAnimalViewAnimalsButtonListener());
        employeeViewAllAnimalsGUI.getjButtonBackViewAllAnimals()
                .addActionListener(new ViewAnimalViewAnimalsButtonListener());

    }

    private void loadTable() throws RemoteException{

        ArrayList<AnimalDTO> animals = animalRMI.viewAllAnimals();

        int columns;
        int rows = 0;

        tableModel.setRowCount(0);

        for (AnimalDTO animal : animals) {
            columns = 0;
            tableModel.addRow(new Object[0]);
            jTableEmployeeViewAllAnimals.setValueAt(animal.getID(), rows, columns++);
            jTableEmployeeViewAllAnimals.setValueAt(animal.getName(), rows, columns++);
            jTableEmployeeViewAllAnimals.setValueAt(animal.getAnimalType(), rows, columns++);
            jTableEmployeeViewAllAnimals.setValueAt(animal.getBreed(), rows, columns++);
            jTableEmployeeViewAllAnimals.setValueAt(animal.getAge(), rows, columns++);
            rows++;
        }
    }

    class ViewAnimalViewAnimalsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = jTableEmployeeViewAllAnimals.getSelectedRow();
            if (row != -1) {
                int animalID = (int) jTableEmployeeViewAllAnimals.getValueAt(row, 0);

                EmployeeViewAnimalGUI employeeViewAnimalGUI = new EmployeeViewAnimalGUI(
                        employeeViewAllAnimalsGUI.getEmployeeDTO(), animalID);
                employeeViewAnimalGUI.setVisible(true);
                employeeViewAllAnimalsGUI.dispose();

            }
        }
    }

    class BackViewAllAnimalsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerDashboardGUI caretakerDashboardGUI = new CaretakerDashboardGUI(employeeViewAllAnimalsGUI.getEmployeeDTO());
            caretakerDashboardGUI.setVisible(true);
            employeeViewAllAnimalsGUI.dispose();
        }
    }
}