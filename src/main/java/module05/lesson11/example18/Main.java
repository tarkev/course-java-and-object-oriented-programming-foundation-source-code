package module05.lesson11.example18;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("First");
        queue.offer("Second");

        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
