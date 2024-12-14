package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI.AddTaskFormGUI;
import GUI.AdminViewAllVolunteeringTasksGUI;
import RMI.VolunteerTaskDTO;
import RMI.VolunteerTaskRMI;
import RMI.AdminDTO;

public class AddTaskController {
    AddTaskFormGUI gui;
    Registry r;

    public AddTaskController(AddTaskFormGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        gui.getjButton1AddTask().addActionListener(new AddTaskListener());
    }

    class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                // Getting the values from form
                String taskName = gui.getjTextFieldTaskName().getText();
                String taskType = gui.getjTextFieldTaskType().getText();
                String taskDate = gui.getjTextFieldTaskDate().getText();
                String taskDescription = gui.jTextFieldTaskDescription().getText();
                Boolean taskCompleted = false;

                // Validate inputs
                if (taskName.isEmpty() || taskType.isEmpty() || taskDate.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(gui, "Please fill in all fields");
                    return;
                }

                // Create task object
                VolunteerTaskDTO task = new VolunteerTaskDTO(taskName, taskType, taskDate, taskCompleted,
                        taskDescription);

                // Save task using RMI
                VolunteerTaskRMI volunteerTaskRMI = (VolunteerTaskRMI) r.lookup("VolunteerTask");
                volunteerTaskRMI.addVolunteerTask(task);

                javax.swing.JOptionPane.showMessageDialog(gui, "Task added successfully");

                // Close form and return to task list
                gui.dispose();
                AdminViewAllVolunteeringTasksGUI taskListGUI = new AdminViewAllVolunteeringTasksGUI();
                AdminViewAllVolunteeringTasksController taskListController = new AdminViewAllVolunteeringTasksController(
                        taskListGUI, r);
                taskListGUI.setLocationRelativeTo(null);
                taskListGUI.setVisible(true);
                new AdminViewAllVolunteeringTasksController(taskListGUI, r);

            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(AddTaskController.class.getName()).log(Level.SEVERE, null, ex);
                javax.swing.JOptionPane.showMessageDialog(gui, "Error adding task: " + ex.getMessage());
            }
        }
    }
}