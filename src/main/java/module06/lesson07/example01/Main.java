// Generated from modules/06-algorithms-and-problem-solving-with-java/07-heaps-and-priorityqueue.md by tools/extract_code.py. Edit the lesson, not this file.
package module06.lesson07.example01;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Comparator<Task> ordering = Comparator.comparing(Task::getPriority)
                .thenComparingLong(Task::getSequence);

        PriorityQueue<Task> tasks = new PriorityQueue<>(ordering);

        tasks.offer(new Task(1L, "Generate report", Priority.NORMAL));

        tasks.offer(new Task(2L, "Fix production outage", Priority.CRITICAL));

        tasks.offer(new Task(3L, "Send welcome email", Priority.LOW));

        tasks.offer(new Task(4L, "Investigate failed payment", Priority.HIGH));

        while (!tasks.isEmpty()) {
            Task task = tasks.poll();

            System.out.println(task.getPriority() + " - " + task.getDescription());
        }
    }

    enum Priority {
        CRITICAL, HIGH, NORMAL, LOW
    }

    static final class Task {

        private final long sequence;
        private final String description;
        private final Priority priority;

        Task(long sequence, String description, Priority priority) {
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

        Priority getPriority() {
            return priority;
        }
    }
}
