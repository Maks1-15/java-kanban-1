package manager;

import task.Epic;
import task.Status;
import task.Subtask;
import task.Task;

import java.io.*;
import java.util.*;

public class FileBackedTaskManager extends InMemoryTaskManager {

    private final File file;

    public FileBackedTaskManager(File file) {
        this.file = file;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("id,type,name,status,description,epic\n");
            writeTasks(writer, getAllTask());
            writeTasks(writer, getAllEpic());
            writeTasks(writer, getAllSubtask());

        } catch (IOException e) {
            throw new ManagerSaveException("Ошибка при сохранении файла");
        }
    }


    public static FileBackedTaskManager loadFromFile(File file) {
        FileBackedTaskManager fbtm = new FileBackedTaskManager(file);
        if (!file.exists()) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Скипаем 1 строку
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                try {
                    Task task = parseTaskFromString(line);
                    if (task instanceof Epic) {
                        fbtm.epics.put(task.getId(), (Epic) task);
                    } else if (task instanceof Subtask) {
                        fbtm.subtasks.put(task.getId(), (Subtask) task);
                    } else {
                        fbtm.tasks.put(task.getId(), task);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fbtm;
    }

    private <T extends Task> void writeTasks(BufferedWriter writer, Collection<T> tasks) throws IOException {
        for (T task : tasks) {
            writer.write(task.toFileString() + System.lineSeparator());
        }
    }

    private static Task parseTaskFromString(String line) {
        String[] arrayString = line.split(",");

        int id = Integer.parseInt(arrayString[0]);
        String type = arrayString[1];
        String name = arrayString[2];
        String description = arrayString[3];
        Status status = Status.valueOf(arrayString[4]);

        switch (type) {
            case "TASK":
                return new Task(id, name, description, status);
            case "EPIC":
                return new Epic(id, name, description, status);
            case "SUBTASK": {
                int epicId = Integer.parseInt(arrayString[5]);
                return new Subtask(id, name, description, status, epicId);
            }
            default:
                System.out.println("Неизвестная задача");
        }
        return null;
    }

    @Override
    public int createEpic(Epic epic) {
        save();
        return super.createEpic(epic);
    }

    @Override
    public int createTask(Task task) {
        save();
        return super.createTask(task);
    }

    @Override
    public int createSubtask(Subtask subtask) {
        save();
        return super.createSubtask(subtask);
    }

    @Override
    public int updateTask(Task task) {
        save();
        return super.updateTask(task);
    }

    @Override
    public int updateEpic(Epic epic) {
        save();
        return super.updateEpic(epic);
    }

    @Override
    public int updateSubtask(Subtask subtask) {
        save();
        return super.updateSubtask(subtask);
    }

    @Override
    public int removeTaskId(int id) {
        save();
        return super.removeTaskId(id);
    }

    @Override
    public int removeEpicId(int id) {
        save();
        return super.removeEpicId(id);
    }

    @Override
    public int removeSubtaskId(int id) {
        save();
        return super.removeSubtaskId(id);
    }

    @Override
    public void removeTasks() {
        save();
        super.removeTasks();
    }

    @Override
    public void removeEpics() {
        save();
        super.removeEpics();
    }

    @Override
    public void removeSubtasks() {
        save();
        super.removeSubtasks();
    }
}
