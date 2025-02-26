package manager;

import task.Task;

import java.util.List;

public interface HistoryManager {

    int add(Task task);

    void remove(int id);

    List<Task> getHistory();
}
