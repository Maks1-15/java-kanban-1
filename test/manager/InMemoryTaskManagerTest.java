package manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.*;

public class InMemoryTaskManagerTest {

    InMemoryTaskManager tm = new InMemoryTaskManager();
    Task task;
    // Создание задач

    @BeforeEach
    public void beforeEach() {
        task = new Task("task", "des", Status.NEW);
    }

    @Test
    void createTaskTest() {
        assertEquals(1, tm.createTask(task));
    }

    @Test
    void updateTaskTest() {
        task.setStatus(Status.DONE);
        assertEquals(1, tm.updateTask(task));
    }

    @Test
    void getIdTaskTest() {
        Task task1 = new Task("task1", "des", Status.NEW);
        Task task2 = new Task("task2", "des", Status.NEW);
        tm.createTask(task1);
        tm.createTask(task2);
        assertEquals(task2, tm.getIdTask(task2.getId()));
    }

    @Test
    void removeTaskIdTest() {
        Task task1 = new Task("task1", "des", Status.NEW);
        Task task2 = new Task("task2", "des", Status.NEW);
        tm.createTask(task1);
        tm.createTask(task2);
        assertEquals(1, tm.removeTaskId(task2.getId()));
    }

    @Test
    void removeEpicIdTest() {
        Epic epic1 = new Epic("epic1", "des");
        Epic epic2 = new Epic("epic1", "des");
        tm.createEpic(epic1);
        tm.createEpic(epic2);
        assertEquals(1, tm.removeEpicId(epic1.getId()));
    }
}