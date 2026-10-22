package module05.lesson11.example19;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static String processNext(Queue<String> queue) {
        String next = queue.poll();
        if (next == null) {
            return "No work";
        }
        return next;
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("Enroll Nur");
        System.out.println(processNext(queue));
        System.out.println(processNext(queue));
    }
}
