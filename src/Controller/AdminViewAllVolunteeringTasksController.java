package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI.AddTaskFormGUI;
import GUI.AdminViewAllVolunteeringTasksGUI;
import RMI.VolunteerTaskDTO;
import RMI.VolunteerTaskRMI;
import RMI.AdminDTO;

public class AdminViewAllVolunteeringTasksController {

    AdminViewAllVolunteeringTasksGUI gui;
    Registry r;

    public AdminViewAllVolunteeringTasksController(AdminViewAllVolunteeringTasksGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        gui.getjButtonAddTask().addActionListener(new openTaskForm());
        gui.getjButtonAdminBack().addActionListener(new goBack());
        gui.getjButtonRemoveTask().addActionListener(new removeTask());

        loadAllTasks();
    }

    private void loadAllTasks() {
        try {
            VolunteerTaskRMI volunteerTaskRMI = (VolunteerTaskRMI) r.lookup("VolunteerTask");
            ArrayList<VolunteerTaskDTO> tasks = volunteerTaskRMI.viewAllVolunteerTask();

            javax.swing.JTable table = gui.getjTableAllVolunteeringTasks();
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
            Logger.getLogger(ViewAllTasksController.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(gui, "Error loading tasks: " + ex.getMessage());
        }
    }

    class openTaskForm implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            AddTaskFormGUI addTaskFormGUI = new AddTaskFormGUI();
            addTaskFormGUI.setLocationRelativeTo(null);
            addTaskFormGUI.setVisible(true);
            AddTaskController addTaskController = new AddTaskController(addTaskFormGUI, r);
            // Close the current GUI
            gui.setVisible(false);
        }
    }

    class goBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // TODO: return to admin dashboard
            gui.setVisible(false);
        }
    }

    class removeTask implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                VolunteerTaskRMI volunteerTaskRMI = (VolunteerTaskRMI) r.lookup("VolunteerTask");
                javax.swing.JTable table = gui.getjTableAllVolunteeringTasks();
                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    javax.swing.JOptionPane.showMessageDialog(gui, "Please select a task to remove");
                    return;
                }

                int taskID = (int) table.getValueAt(selectedRow, 0);
                volunteerTaskRMI.removeVolunteerTask(taskID);
                javax.swing.JOptionPane.showMessageDialog(gui, "Task removed successfully");
                loadAllTasks(); // Refresh the table
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(AdminViewAllVolunteeringTasksController.class.getName()).log(Level.SEVERE, null, ex);
                javax.swing.JOptionPane.showMessageDialog(gui, "Error removing task: " + ex.getMessage());
            }
        }
    }

}
