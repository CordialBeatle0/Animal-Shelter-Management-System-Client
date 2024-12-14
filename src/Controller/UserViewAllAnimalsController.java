package Controller;

import GUI.UserViewAllAnimalsGUI;
import RMI.AnimalDTO;
import RMI.AnimalRMI;
import RMI.VolunteerTaskRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import GUI.UserDashboardGUI;

public class UserViewAllAnimalsController {
    private UserViewAllAnimalsGUI gui;
    private Registry r;

    public UserViewAllAnimalsController(UserViewAllAnimalsGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        // Add action listeners
        this.gui.getjButtonBackUserViewAllAnimals().addActionListener(new backButtonListener());
        this.gui.getjButtonAdoptAnimalUserViewAnimals().addActionListener(new adoptAnimalListener());
        this.gui.getjButtonFosterAnimalUserViewAnimals().addActionListener(new fosterAnimalListener());
        this.gui.getjButtonSponsorAnimalUserViewAnimals().addActionListener(new sponsorAnimalListener());

        // Fill the table with animals
        fillAnimalTable();
    }

    private void fillAnimalTable() {
        try {
            AnimalRMI animalRMI = (AnimalRMI) r.lookup("Animal");
            ArrayList<AnimalDTO> animals = animalRMI.viewAllAnimals();

            DefaultTableModel model = (DefaultTableModel) gui.getjTableAnimalDetailsUserViewAllAnimals().getModel();
            // Clear existing rows
            model.setRowCount(0);

            // Add animals to table
            for (AnimalDTO animal : animals) {
                Object[] row = {
                        animal.getID(),
                        animal.getName(),
                        animal.getAnimalType(),
                        animal.getBreed(),
                        animal.getAge(),
                        animal.isAdopted() ? "Yes" : "No",
                        animal.isFostered() ? "Yes" : "No",
                        animal.isSponsored() ? "Yes" : "No"
                };
                model.addRow(row);
            }
        } catch (RemoteException ex) {
            System.out.println("Error retrieving animals: " + ex.getMessage());
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserDashboardGUI dashboardGUI = new UserDashboardGUI(gui.getUser());
            UserDashboardController dashboardController = new UserDashboardController(dashboardGUI, r);
            dashboardGUI.setVisible(true);
            dashboardGUI.setLocationRelativeTo(null);
            gui.dispose();
        }
    }

    class adoptAnimalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int selectedRow = gui.getjTableAnimalDetailsUserViewAllAnimals().getSelectedRow();

            if (selectedRow != -1) {
                try {
                    AnimalRMI animalRMI = (AnimalRMI) r.lookup("Animal");

                    int animalId = (int) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow, 0);

                    String isAdopted= (String) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow, 5);
                    if (isAdopted == "No") {
                        AnimalDTO selectedAnimal = new AnimalDTO();
                        
                        selectedAnimal.setID(animalId);
                        
                        animalRMI.adoptAnimal(selectedAnimal, gui.getUser());
                        
                        fillAnimalTable(); // Refresh the table

                        JOptionPane.showMessageDialog(null, "YAY! you are now pround parent!!!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "This animal has already been adopted.");
                        return;
                    }


                } catch (RemoteException ex) {
                    System.out.println("Error adopting animal: " + ex.getMessage());
                } catch (NotBoundException e1) {
                }
            }
        }
    }

    class fosterAnimalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = gui.getjTableAnimalDetailsUserViewAllAnimals().getSelectedRow();

            if (selectedRow != -1) {
                try {
                    AnimalRMI animalRMI = (AnimalRMI) r.lookup("Animal");

                    int animalId = (int) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow, 0);

                    String isFostered = (String) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow,
                            6);

                    String isAdopted= (String) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow, 5);
                    if (isFostered == "No" && isAdopted == "No") {

                        AnimalDTO selectedAnimal = new AnimalDTO();

                        selectedAnimal.setID(animalId);

                        animalRMI.fosterAnimal(selectedAnimal, gui.getUser());

                        fillAnimalTable(); // Refresh the table

                        JOptionPane.showMessageDialog(null, "Thank you for welcoming others to your home!");
                    } else {
                        JOptionPane.showMessageDialog(null, "This animal has already been Fostered or Adopted.");
                        return;
                    }

                } catch (RemoteException ex) {
                    System.out.println("Error fostering animal: " + ex.getMessage());
                } catch (NotBoundException e1) {
                }
            }
        }
    }

    class sponsorAnimalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = gui.getjTableAnimalDetailsUserViewAllAnimals().getSelectedRow();

            if (selectedRow != -1) {
                try {
                    AnimalRMI animalRMI = (AnimalRMI) r.lookup("Animal");

                    int animalId = (int) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow, 0);

                    String isSponsored = (String) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow,
                            7);
                            
                    String isFostered = (String) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow,
                            6);

                    String isAdopted= (String) gui.getjTableAnimalDetailsUserViewAllAnimals().getValueAt(selectedRow, 5);

                    if ( isFostered == "No" && isAdopted == "No") {

                        AnimalDTO selectedAnimal = new AnimalDTO();

                        selectedAnimal.setID(animalId);

                        animalRMI.sponsorAnimal(selectedAnimal, gui.getUser());

                        fillAnimalTable(); // Refresh the table

                        JOptionPane.showMessageDialog(null, "All your help is appreciated!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "This animal has already been Fostered or Adopted.");
                        return;
                    }

                } catch (RemoteException ex) {
                    System.out.println("Error sponsoring animal: " + ex.getMessage());
                } catch (NotBoundException e1) {
                }
            }
        }
    }
}