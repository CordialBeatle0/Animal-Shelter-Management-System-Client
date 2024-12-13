package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI.ViewAllTasksGUI;
import GUI.VolunteerDashboardGUI;
import RMI.VolunteerTaskDTO;
import RMI.VolunteerTaskRMI;
import RMI.VolunteerRMI;

public class ViewAllTasksController {

    ViewAllTasksGUI gui;
    Registry r;

    public ViewAllTasksController(ViewAllTasksGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        gui.getjButtonAllVolunteerAssign().addActionListener(new acceptTask());
        gui.getjButtonAllVolunteerBack().addActionListener(new goBack());

        loadAllTasks();
    }

    private void loadAllTasks() {
        try {
            VolunteerTaskRMI volunteerTaskRMI = (VolunteerTaskRMI) r.lookup("volunteerTask");
            ArrayList<VolunteerTaskDTO> tasks = volunteerTaskRMI.viewAllVolunteerTask();

            javax.swing.JTable table = gui.getjTableAllVolunteeringTasks();
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (VolunteerTaskDTO task : tasks) {
                Object[] row = {
                        task.getTaskName(),
                        task.getType(),
                        task.getDescription(),
                        task.getDate()
                };
                model.addRow(row);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ViewAllTasksController.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(gui, "Error loading tasks: " + ex.getMessage());
        }
    }

    class acceptTask implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                javax.swing.JTable table = gui.getjTableAllVolunteeringTasks();
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    int taskId = (int) table.getValueAt(selectedRow, 0);
                    VolunteerRMI volunteerRMI = (VolunteerRMI) r.lookup("volunteer");
                    volunteerRMI.assignVolunteer(taskId, gui.getVolunteerDTO().getID());

                    javax.swing.JOptionPane.showMessageDialog(gui, "Task assigned successfully!");
                    loadAllTasks(); // Refresh the task list
                } else {
                    javax.swing.JOptionPane.showMessageDialog(gui, "Please select a task to get assigned.");
                }
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(ViewAllTasksController.class.getName()).log(Level.SEVERE, null, ex);
                javax.swing.JOptionPane.showMessageDialog(gui, "Error assigning task: " + ex.getMessage());
            }
        }
    }

    class goBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            VolunteerDashboardGUI volunteerDashboardGUI = new VolunteerDashboardGUI(gui.getVolunteerDTO());
            volunteerDashboardGUI.setLocationRelativeTo(null);
            volunteerDashboardGUI.setVisible(true);
            VolunteerDashboardContoller volunteerDashboardContoller = new VolunteerDashboardContoller(
                    volunteerDashboardGUI, r);

            // Close the current GUI
            gui.setVisible(false);
        }
    }
}