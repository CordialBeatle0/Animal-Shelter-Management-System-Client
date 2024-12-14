package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI.ViewMyTasksGUI;
import GUI.VolunteerDashboardGUI;
import RMI.VolunteerTaskDTO;
import RMI.VolunteerTaskRMI;

public class ViewMyTasksController {

    ViewMyTasksGUI gui;
    Registry r;

    public ViewMyTasksController(ViewMyTasksGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        gui.getjButtonRecordTask().addActionListener(new recordTask());
        gui.getjButtonMyVolunteerBack().addActionListener(new goBack());

        loadMyTasks();
    }

    public void loadMyTasks() {
        try {

            VolunteerTaskRMI volunteerTaskRMI = (VolunteerTaskRMI) r.lookup("VolunteerTask");
            ArrayList<VolunteerTaskDTO> tasks = volunteerTaskRMI
                    .viewAssignedVolunteerTask(gui.getVolunteerDTO().getID());

            javax.swing.JTable table = gui.getjTableMyVolunteeringTasks();
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (VolunteerTaskDTO task : tasks) {
                Object[] row = {
                        task.getID(),
                        task.getTaskName(),
                        task.getType(),
                        task.getDescription(),
                        task.getDate()
                };
                model.addRow(row);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ViewMyTasksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class recordTask implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                javax.swing.JTable table = gui.getjTableMyVolunteeringTasks();
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    int taskId = (int) table.getValueAt(selectedRow, 0);
                    VolunteerTaskRMI volunteerTaskRMI = (VolunteerTaskRMI) r.lookup("VolunteerTask");
                    volunteerTaskRMI.recordTaskCompletion(taskId);
                    loadMyTasks();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(gui, "Please select a task to record.");
                }
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(ViewMyTasksController.class.getName()).log(Level.SEVERE, null, ex);
                javax.swing.JOptionPane.showMessageDialog(gui, "Error recording task completion: " + ex.getMessage());
            }
        }
    }

    class goBack implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            VolunteerDashboardGUI dVolunteerDashboardGUI = new VolunteerDashboardGUI(gui.getVolunteerDTO());
            dVolunteerDashboardGUI.setLocationRelativeTo(null);
            dVolunteerDashboardGUI.setVisible(true);
            VolunteerDashboardContoller volunteerDashboardContoller = new VolunteerDashboardContoller(
                    dVolunteerDashboardGUI, r);

            // close the current GUI
            gui.setVisible(false);
        }
    }

}
