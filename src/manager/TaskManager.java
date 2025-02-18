package manager;

import task.Epic;
import task.Subtask;
import task.Task;

import java.util.Collection;
import java.util.List;

public interface TaskManager {
    Collection<Task> getAllTask();

    Collection<Epic> getAllEpic();

    Collection<Subtask> getAllSubtask();

    void removeTasks();

    void removeEpics();

    void removeSubtasks();

    Task getIdTask(int id);

    Epic getIdEpic(int id);

    Subtask getIdSubtask(int id);

    int createTask(Task task);

    int createEpic(Epic epic);

    int createSubtask(Subtask subtask);

    int updateTask(Task task);

    int updateEpic(Epic epic);

    int updateSubtask(Subtask subtask);

    int removeTaskId(int id);

    int removeEpicId(int id);

    int removeSubtaskId(int id);

    // Возврат Subtask по Epic
    List<Subtask> getEpicSubtask(Epic epic);

    void updateEpicStatus(int epicId);
}
