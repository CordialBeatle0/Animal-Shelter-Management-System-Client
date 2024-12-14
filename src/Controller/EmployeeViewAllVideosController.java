package Controller;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.rmi.RemoteException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.CaretakerDashboardGUI;
import GUI.CaretakerUploadTrainingVideoGUI;
import GUI.EmployeeViewAllVideosGUI;
import RMI.TrainingDTO;
import RMI.TrainingRMI;

public class EmployeeViewAllVideosController {

    EmployeeViewAllVideosGUI employeeViewAllVideosGUI;
    Registry registry;
    TrainingRMI trainingRMI;
    JTable jTableEmployeeViewAllVideos;
    DefaultTableModel tableModel;

    public EmployeeViewAllVideosController(EmployeeViewAllVideosGUI employeeViewAllVideosGUI, Registry registry) {
        this.employeeViewAllVideosGUI = employeeViewAllVideosGUI;
        this.registry = registry;
        jTableEmployeeViewAllVideos = employeeViewAllVideosGUI.getjTableTrainingVideoViewAllVideos();
        tableModel = (DefaultTableModel) jTableEmployeeViewAllVideos.getModel();
        try {
            trainingRMI = (TrainingRMI) registry.lookup("Training");
            loadTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        employeeViewAllVideosGUI.getjButtonBackViewAllVideos().addActionListener(new BackAllVideosButtonListener());
        employeeViewAllVideosGUI.getjButtonRemoveVideoViewAllVideos()
                .addActionListener(new RemoveVideoButtonListener());
        employeeViewAllVideosGUI.getjButtonUploadTrainingVideoViewAllVideos()
                .addActionListener(new UploadVideoButtonListener());
    }

    private void loadTable() throws RemoteException {
        ArrayList<TrainingDTO> trainings = trainingRMI.viewAllTrainingVideos();
        int columns;
        int rows = 0;
        tableModel.setRowCount(0);
        for (TrainingDTO training : trainings) {
            columns = 0;
            tableModel.addRow(new Object[0]);
            jTableEmployeeViewAllVideos.setValueAt(training.getUrl(), rows, columns++);
            jTableEmployeeViewAllVideos.setValueAt(training.getRuntime(), rows, columns++);
            jTableEmployeeViewAllVideos.setValueAt(training.getDescription(), rows, columns++);
            rows++;
        }
    }

    class BackAllVideosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerDashboardGUI caretakerDashboardGUI = new CaretakerDashboardGUI();
            CaretakerDashboardController caretakerDashboardController = new CaretakerDashboardController(
                    caretakerDashboardGUI, registry);
            caretakerDashboardGUI.setVisible(true);
            employeeViewAllVideosGUI.dispose();
        }
    }

    class RemoveVideoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = jTableEmployeeViewAllVideos.getSelectedRow();
            if (row != -1) {
                int id = (int) jTableEmployeeViewAllVideos.getValueAt(row, 0);
                try {
                    trainingRMI.removeTrainingVideo(id);
                    loadTable();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    class UploadVideoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CaretakerUploadTrainingVideoGUI caretakerUploadTrainingVideoGUI = new CaretakerUploadTrainingVideoGUI(
                    employeeViewAllVideosGUI.getEmployeeDTO());
            CaretakerUploadTrainingVideoController caretakerUploadTrainingVideoController = new CaretakerUploadTrainingVideoController(
                    caretakerUploadTrainingVideoGUI, registry);
            caretakerUploadTrainingVideoGUI.setVisible(true);
            employeeViewAllVideosGUI.dispose();
        }
    }

}