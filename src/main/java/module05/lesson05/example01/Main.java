// Generated from modules/05-generics-collections-and-core-data-structures/05-queues-and-fifo-processing.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson05.example01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> tasks = new ArrayDeque<>();

        tasks.offer("Send verification email");

        tasks.offer("Generate certificate");

        tasks.offer("Update learner progress");

        System.out.println("Next: " + tasks.peek());

        while (!tasks.isEmpty()) {
            String task = tasks.poll();

            System.out.println("Processing: " + task);
        }

        System.out.println("Remaining: " + tasks.size());
    }
}
