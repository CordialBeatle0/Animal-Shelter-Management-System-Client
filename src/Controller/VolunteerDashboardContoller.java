package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import GUI.ViewAllTasksGUI;
import GUI.ViewMyTasksGUI;
import GUI.VolunteerDashboardGUI;
import GUI.LoginGUI;
import RMI.VolunteerRMI;

public class VolunteerDashboardContoller {

    private VolunteerDashboardGUI gui;
    private Registry r;

    // The constructor takes the gui and the rmi registry as paramaters
    public VolunteerDashboardContoller(VolunteerDashboardGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;

        // This registers the button with our action listener below (the inner class)

        gui.getjButtonViewMyTasks().addActionListener(new OpenViewMyTaskGUI());

        gui.getjButtonViewAllTasks().addActionListener(new OpenViewAllTasksGUI());

        gui.getjButtonVolunteerResigned().addActionListener(new resigned());

        gui.getjButtonLogout().addActionListener(new logout());
    }

    class OpenViewMyTaskGUI implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Open the GUI for viewing my tasks
            ViewMyTasksGUI myTasksGui = new ViewMyTasksGUI(gui.getVolunteerDTO());
            myTasksGui.setLocationRelativeTo(null);
            myTasksGui.setVisible(true);
            ViewMyTasksController myTasksController = new ViewMyTasksController(myTasksGui, r);

            // close the current GUI
            gui.setVisible(false);
        }

    }

    class OpenViewAllTasksGUI implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Open the GUI for viewing all tasks
            ViewAllTasksGUI allTasksGui = new ViewAllTasksGUI(gui.getVolunteerDTO());
            allTasksGui.setLocationRelativeTo(null);
            allTasksGui.setVisible(true);
            ViewAllTasksController allTasksController = new ViewAllTasksController(allTasksGui, r);

            // close the current GUI
            gui.setVisible(false);
        }
    }

    class logout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setLocationRelativeTo(null);
            loginGUI.setVisible(true);
            LoginController loginController = new LoginController(loginGUI, r);

            // Close the current dashboard
            gui.setVisible(false);
        }

    }

    class resigned implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                // Ask for confirmation
                int choice = javax.swing.JOptionPane.showConfirmDialog(
                        gui,
                        "Are you sure you want to resign from volunteering? This action cannot be undone.",
                        "Confirm Resignation",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE);

                if (choice == javax.swing.JOptionPane.YES_OPTION) {
                    // Remove volunteer from system
                    VolunteerRMI volunteerRMI = (VolunteerRMI) r.lookup("Volunteer");
                    volunteerRMI.removeVolunteer(gui.getVolunteerDTO().getID());

                    // Show success message
                    javax.swing.JOptionPane.showMessageDialog(
                            gui,
                            "You have successfully resigned from volunteering. Thank you for your service!",
                            "Resignation Successful",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);

                    // Return to login screen
                    LoginGUI loginGUI = new LoginGUI();
                    loginGUI.setLocationRelativeTo(null);
                    loginGUI.setVisible(true);
                    LoginController loginController = new LoginController(loginGUI, r);

                    // Close the current dashboard
                    gui.setVisible(false);
                }
            } catch (RemoteException | NotBoundException ex) {
                javax.swing.JOptionPane.showMessageDialog(
                        gui,
                        "Error processing resignation: " + ex.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
