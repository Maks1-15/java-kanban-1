package manager;

import task.Task;

import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private final static int COUNT_TASK = 10;
    private final List<Task> listHistory = new LinkedList<>();

    @Override
    public int add(Task task) {
        if (task == null) {
            return -1;
        }

        if (listHistory.size() == COUNT_TASK) {
            listHistory.removeFirst();
        }

        listHistory.add(task);

        return 1;
    }

    @Override
    public List<Task> getHistory() {
        return listHistory;
    }


}
