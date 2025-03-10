package task;

public class Subtask extends Task {

    private int epicId;

    public Subtask(String name, String description, int epicId) {
        super(name, description, Status.NEW);
        this.epicId = epicId;
    }

    public Subtask(int id, String name, String description, Status status, int epicId) {
        super(id, name, description, status);
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

    public String toFileString() {
        return String.format("%d,%s,%s,%s,%s,%s\n", getId(), "SUBTASK", getName(), getDescription(), getStatus(), getEpicId());
    }
}

