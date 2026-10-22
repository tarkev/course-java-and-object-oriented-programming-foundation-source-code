package module05.lesson11.example21;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static void processAll(Queue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("Enroll Jalisa");
        queue.offer("Enroll Samiul");
        processAll(queue);
        System.out.println(queue.isEmpty());
    }
}
