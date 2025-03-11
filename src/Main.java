import task.*;
import manager.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path directory = Paths.get("E:\\prj\\java-kanban\\src\\resources");
        String fileName = "test.csv";
        File file = directory.resolve(fileName).toFile();

        FileBackedTaskManager fbtm = (FileBackedTaskManager) Managers.getFileBackedTaskManager(file);

        Task task1 = new Task("task1", "des", Status.NEW);
        Task task2 = new Task("task2", "des", Status.NEW);
        Epic epic1 = new Epic("epic1", "des");
        Epic epic2 = new Epic("epic2", "des");

        fbtm.createTask(task1);
        fbtm.createTask(task2);
        fbtm.createEpic(epic1);
        fbtm.createEpic(epic2);

        Subtask subtask1 = new Subtask("subtask1", "des", epic1.getId());
        Subtask subtask2 = new Subtask("subtask2", "des", epic1.getId());
        Subtask subtask3 = new Subtask("subtask3", "des", epic1.getId());

        fbtm.createSubtask(subtask1);
        fbtm.createSubtask(subtask2);
        fbtm.createSubtask(subtask3);

        fbtm.save();

        FileBackedTaskManager newTaskManager = FileBackedTaskManager.loadFromFile(file);

        if (newTaskManager != null) {
            System.out.println("Задачи после загрузки:");
            System.out.println(newTaskManager.getAllTask());
            System.out.println(newTaskManager.getAllEpic());
            System.out.println(newTaskManager.getAllSubtask());
        } else {
            System.out.println("Задачи не загружены");
        }

    }
}
