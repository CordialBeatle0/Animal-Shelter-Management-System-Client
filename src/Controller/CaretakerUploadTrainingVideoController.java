package Controller;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import GUI.CaretakerUploadTrainingVideoGUI;
import GUI.EmployeeViewAllVideosGUI;
import RMI.TrainingDTO;
import RMI.TrainingRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaretakerUploadTrainingVideoController {

    CaretakerUploadTrainingVideoGUI caretakerUploadTrainingVideoGUI;
    Registry registry;
    TrainingRMI trainingRMI;

    public CaretakerUploadTrainingVideoController(CaretakerUploadTrainingVideoGUI caretakerUploadTrainingVideoGUI,
            Registry registry) {
        this.caretakerUploadTrainingVideoGUI = caretakerUploadTrainingVideoGUI;
        this.registry = registry;
        try {
            trainingRMI = (TrainingRMI) registry.lookup("Training");
        } catch (Exception e) {
            e.printStackTrace();
        }

        caretakerUploadTrainingVideoGUI.getjButtonBackUploadTraining().addActionListener(new BackButtonListener());
        caretakerUploadTrainingVideoGUI.getjButtonUploadVideoUploadTraining()
                .addActionListener(new UploadTrainingVideoButtonListener());

    }

    class UploadTrainingVideoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)   {
            String url = caretakerUploadTrainingVideoGUI.getjTextFieldURLUploadTraining().getText();
            float runtime = Float.parseFloat(caretakerUploadTrainingVideoGUI.getjTextFieldRuntimeUploadTraining().getText());
            String description = caretakerUploadTrainingVideoGUI.getjTextFieldDescriptionUploadTraining().getText();

            TrainingDTO trainingDTO = new TrainingDTO();
            trainingDTO.setUrl(url);
            trainingDTO.setRuntime(runtime);
            trainingDTO.setDescription(description);

            try {

                trainingRMI.uploadTrainingVideo(trainingDTO);

            } 
          catch (RemoteException e1) {
            e1.printStackTrace();
          }


        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EmployeeViewAllVideosGUI employeeViewAllVideosGUI = new EmployeeViewAllVideosGUI(
                    caretakerUploadTrainingVideoGUI.getEmployeeDTO());
            EmployeeViewAllVideosController employeeViewAllVideosController = new EmployeeViewAllVideosController(
                employeeViewAllVideosGUI, registry);
            employeeViewAllVideosGUI.setVisible(true);
            caretakerUploadTrainingVideoGUI.dispose();
        }

    }

}