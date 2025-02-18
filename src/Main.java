import manager.TaskManager;
import task.Epic;
import task.Status;
import task.Subtask;
import task.Task;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр TaskManager
        TaskManager taskManager = new TaskManager();

        // 1. Создание задач
        System.out.println("\n--- 1. Создание задач ---");
        Task task1 = new Task("Сделать уборку", "Пропылесосить и вымыть полы", Status.NEW);
        Task task2 = new Task("Купить продукты", "Молоко, хлеб, яйца", Status.IN_PROGRESS);

        int taskId1 = taskManager.createTask(task1);
        int taskId2 = taskManager.createTask(task2);

        System.out.println("Создана задача 1 с ID: " + taskId1);
        System.out.println("Создана задача 2 с ID: " + taskId2);

        // 2. Получение всех задач
        System.out.println("\n--- 2. Получение всех задач ---");
        Collection<Task> allTasks = taskManager.getAllTask();
        System.out.println("Все задачи: " + allTasks);


        // 3. Получение задачи по ID
        System.out.println("\n--- 3. Получение задачи по ID ---");
        Task retrievedTask = taskManager.getIdTask(taskId1);
        System.out.println("Задача с ID " + taskId1 + ": " + retrievedTask);

        // 4. Обновление задач
        System.out.println("\n--- 4. Обновление задач ---");
        task1.setStatus(Status.DONE);
        int updateResult = taskManager.updateTask(task1);
        System.out.println("Результат обновления задачи " + taskId1 + ": " + updateResult);
        System.out.println("Обновленная задача " + taskManager.getIdTask(taskId1));

    }
}
