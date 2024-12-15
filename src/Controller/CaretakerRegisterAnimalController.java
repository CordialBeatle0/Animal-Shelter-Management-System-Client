package Controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;
import javax.swing.text.Caret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.CaretakerRegisterAnimalGUI;
import RMI.AnimalDTO;
import RMI.AnimalRMI;
import GUI.CaretakerDashboardGUI;

public class CaretakerRegisterAnimalController {
    CaretakerRegisterAnimalGUI caretakerRegisterAnimalGUI;
    Registry registry;

    public CaretakerRegisterAnimalController(CaretakerRegisterAnimalGUI caretakerRegisterAnimalGUI, Registry registry) {
        this.caretakerRegisterAnimalGUI = caretakerRegisterAnimalGUI;
        this.registry = registry;

        caretakerRegisterAnimalGUI.getjButtonRegisterAnimalRegisteration()
                .addActionListener(new RegisterAnimalButtonListener());
        caretakerRegisterAnimalGUI.getjButtonBackRegisterAnimal().addActionListener(new BackButtonListener());
    }

    class RegisterAnimalButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = caretakerRegisterAnimalGUI.getjTextFieldAnimalNameRegister().getText();
            String animalType = caretakerRegisterAnimalGUI.getjTextFieldAnimalTypeRegister().getText();
            String breed = caretakerRegisterAnimalGUI.getjTextFieldAnimalBreedRegister().getText();
            int age = Integer.parseInt(caretakerRegisterAnimalGUI.getjTextFieldAnimalAge().getText());
            String lastFeedingTime = caretakerRegisterAnimalGUI.getjTextFieldLastFeedingRegister().getText();

            // checking Adopted data
            boolean adopted = false;
            if (caretakerRegisterAnimalGUI.getjRadioButtonTrueAdoptedStatus().isSelected()) {
                adopted = true;
            } else if (caretakerRegisterAnimalGUI.getjRadioButtonFalseAdoptedStatus().isSelected()) {
                adopted = false;
            } else {
                JOptionPane.showMessageDialog(caretakerRegisterAnimalGUI, "Please select an adopted status");
            }

            // checking Sponsored data
            boolean sponsored = false;
            if (caretakerRegisterAnimalGUI.getjRadioButtonTrueSponsored().isSelected()) {
                sponsored = true;
            } else if (caretakerRegisterAnimalGUI.getjRadioButtonFalseSponsored().isSelected()) {
                sponsored = false;
            } else {
                JOptionPane.showMessageDialog(caretakerRegisterAnimalGUI, "Please select a sponsored status");
            }

            // checking Fostered data
            boolean fostered = false;
            if (caretakerRegisterAnimalGUI.getjRadioButtonTrueFostered().isSelected()) {
                fostered = true;
            } else if (caretakerRegisterAnimalGUI.getjRadioButtonFalseFostered().isSelected()) {
                fostered = false;
            } else {
                JOptionPane.showMessageDialog(caretakerRegisterAnimalGUI, "Please select a fostered status");
            }

            AnimalDTO animal = new AnimalDTO(name, animalType, breed, age, lastFeedingTime, adopted, sponsored,
                    fostered);
            try {
                AnimalRMI animalRMI = (AnimalRMI) registry.lookup("Animal");
                animalRMI.registerAnimal(animal);
                JOptionPane.showMessageDialog(caretakerRegisterAnimalGUI, "Registration Complete!");
                CaretakerDashboardGUI caretakerDashboardGUI = new CaretakerDashboardGUI(
                    caretakerRegisterAnimalGUI.getCaretakerDTO());
            CaretakerDashboardController caretakerDashboardController = new CaretakerDashboardController(
                    caretakerDashboardGUI, registry);
            caretakerDashboardGUI.setVisible(true);
            caretakerDashboardGUI.setLocationRelativeTo(null);
            caretakerRegisterAnimalGUI.dispose();

            } catch (RemoteException e1) {
                JOptionPane.showMessageDialog(caretakerRegisterAnimalGUI, "Remote Exception Error");
            } catch (NotBoundException e1) {
                JOptionPane.showMessageDialog(caretakerRegisterAnimalGUI, "Not Bound Exception Error");
            }

        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerDashboardGUI caretakerDashboardGUI = new CaretakerDashboardGUI(
                    caretakerRegisterAnimalGUI.getCaretakerDTO());
            CaretakerDashboardController caretakerDashboardController = new CaretakerDashboardController(
                    caretakerDashboardGUI, registry);
            caretakerDashboardGUI.setVisible(true);
            caretakerDashboardGUI.setLocationRelativeTo(null);
            caretakerRegisterAnimalGUI.dispose();
        }
    }

}