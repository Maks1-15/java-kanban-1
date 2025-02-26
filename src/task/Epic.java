package task;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {

    private List<Integer> epicSubtaskId;

    public Epic(String name, String description) {
        super(name, description, Status.NEW);
        this.epicSubtaskId = new ArrayList<>();
    }

    public List<Integer> getEpicSubtask() {
        return epicSubtaskId;
    }

    public void addEpicSubtask(int id) {
        this.epicSubtaskId.add(id);
    }

    public void removeSubtaskId(Integer subtaskId) {
        this.epicSubtaskId.remove(subtaskId);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() + '\'' +
                ", listSubtask=' " + getEpicSubtask() + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}
