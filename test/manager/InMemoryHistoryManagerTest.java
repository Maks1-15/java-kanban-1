package manager;

import org.junit.jupiter.api.Test;
import task.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    HistoryManager hm = new InMemoryHistoryManager();
    TaskManager tm = new InMemoryTaskManager();

    @Test
    void addTest() {
        Task task1 = new Task("task1", "des", Status.NEW);
        Task task2 = new Task("task2", "des", Status.NEW);
        assertEquals(1, hm.add(task2));
    }

}



