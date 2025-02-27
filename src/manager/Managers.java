package manager;

import task.Task;

import java.util.List;

public final class Managers {

    TaskManager tm = new InMemoryTaskManager();

    public static TaskManager getDefaultTaskManager() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistoryManager() {
        return new InMemoryHistoryManager();
    }

    public List<Task> getDefaultHistory() {
        return tm.getHistory();
    }
}
