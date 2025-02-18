package manager;

import java.util.List;

public final class Managers {

    public static TaskManager getDefaultTaskManager() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistoryManager() {
        return new InMemoryHistoryManager();
    }

    public HistoryManager getDefaultHistory() {
        return null;
    }
}
