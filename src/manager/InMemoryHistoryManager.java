package manager;

import task.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private final Map<Integer, Node> mapHistory = new HashMap<>();
    private Node head;
    private Node tail;

    public Node linkLast(Task task) {
        final Node oldTail = tail;
        final Node newNode = new Node(oldTail, task, null);
        tail = newNode;
        if (oldTail == null) {
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
        return oldTail;
    }

    void removeNode(Node n) {
        if (n != null && mapHistory.containsValue(n)) {
            mapHistory.values().remove(n);
        }
    }

    static class Node {

        private Node next;
        private Task task;
        private Node prev;

        public Node(Node prev, Task task, Node next) {
            this.prev = prev;
            this.task = task;
            this.next = next;
        }

        public Task getTask() {
            return task;
        }

    }

    @Override
    public int add(Task task) {
        if (task == null) {
            return -1;
        }
        mapHistory.put(task.getId(), linkLast(task));
        return 1;
    }

    @Override
    public List<Task> getHistory() {
        List<Task> taskList = new ArrayList<>();
        Node node = head;
        while (Objects.nonNull(node)) {
            taskList.add(node.getTask());
            node = node.next;
        }
        return taskList;
    }

    @Override
    public void remove(int id) {
        mapHistory.remove(id);
    }
}
