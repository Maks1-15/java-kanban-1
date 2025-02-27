import manager.HistoryManager;
import manager.InMemoryHistoryManager;
import manager.InMemoryTaskManager;
import manager.TaskManager;
import task.Epic;
import task.Status;
import task.Subtask;
import task.Task;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр TaskManager
        TaskManager tm = new InMemoryTaskManager();
        HistoryManager hm = new InMemoryHistoryManager();

        Task task1 = new Task("task1", "des", Status.NEW);
        Task task2 = new Task("task2", "des", Status.NEW);
        Epic epic1 = new Epic("epic1", "des");
        Epic epic2 = new Epic("epic2", "des");

        tm.createTask(task1);
        tm.createTask(task2);
        tm.createEpic(epic1);
        tm.createEpic(epic2);

        Subtask subtask1 = new Subtask("subtask1", "des", epic1.getId());
        Subtask subtask2 = new Subtask("subtask2", "des", epic1.getId());
        Subtask subtask3 = new Subtask("subtask3", "des", epic1.getId());

        tm.createSubtask(subtask1);
        tm.createSubtask(subtask2);
        tm.createSubtask(subtask3);

        tm.getIdTask(task1.getId());
        tm.getIdTask(task2.getId());
        tm.getIdEpic(epic1.getId());
        tm.getIdSubtask(subtask1.getId());
        tm.getIdEpic(epic1.getId());
        tm.getIdEpic(epic1.getId());
        tm.getIdEpic(epic1.getId());

        System.out.println(tm.getHistory());

    }
}
