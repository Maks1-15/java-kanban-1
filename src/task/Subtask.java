package task;

public class Subtask extends Task{

    private int epicId;

    public Subtask(String name, String description, int epicId) {
        super(name, description, Status.NEW);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() + '\'' +
                ", epicId=' " + getEpicId() + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}

