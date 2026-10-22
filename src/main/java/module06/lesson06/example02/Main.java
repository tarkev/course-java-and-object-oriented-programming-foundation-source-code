package module06.lesson06.example02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> tasks = new ArrayDeque<>();
        tasks.offer("Generate invoice");
        tasks.offer("Send email");
        tasks.offer("Update report");

        processAll(tasks);
    }

    static void processAll(Queue<String> tasks) {
        while (!tasks.isEmpty()) {
            String task = tasks.poll();
            System.out.println("Processing: " + task);
        }
    }
}
