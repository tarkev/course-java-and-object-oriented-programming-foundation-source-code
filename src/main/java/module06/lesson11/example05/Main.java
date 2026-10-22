package module06.lesson11.example05;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Comparator<Task> ordering = Comparator.comparingInt(Task::getPriority)
                .thenComparingLong(Task::getSequence);
        PriorityQueue<Task> tasks = new PriorityQueue<>(ordering);

        tasks.offer(new Task(1L, "Send receipt to Nur", 2));
        tasks.offer(new Task(2L, "Fix login for Subu", 1));
        tasks.offer(new Task(3L, "Send receipt to Sumu", 2));
        tasks.offer(new Task(4L, "Send receipt to Jalisa", 2));

        while (!tasks.isEmpty()) {
            Task task = tasks.poll();
            System.out.println(task.getPriority() + " - " + task.getDescription());
        }
    }
}

final class Task {

    private final long sequence;
    private final String description;
    private final int priority;

    Task(long sequence, String description, int priority) {
        this.sequence = sequence;
        this.description = description;
        this.priority = priority;
    }

    long getSequence() {
        return sequence;
    }

    String getDescription() {
        return description;
    }

    int getPriority() {
        return priority;
    }
}
