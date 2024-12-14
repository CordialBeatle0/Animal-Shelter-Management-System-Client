package RMI;

import java.io.Serializable;

public class VolunteerTaskDTO implements Serializable {
    private int ID;
    private String taskName;
    private String type;
    private String date;
    private boolean completionStatus;
    private String description;

    public VolunteerTaskDTO() {
    }

    public VolunteerTaskDTO(String taskName, String type, String date, boolean completionStatus, String description) {
        this.taskName = taskName;
        this.type = type;
        this.date = date;
        this.completionStatus = completionStatus;
        this.description = description;
    }

    public VolunteerTaskDTO(int ID, String taskName, String type, String date, boolean completionStatus,
            String description) {
        this.ID = ID;
        this.taskName = taskName;
        this.type = type;
        this.date = date;
        this.completionStatus = completionStatus;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
