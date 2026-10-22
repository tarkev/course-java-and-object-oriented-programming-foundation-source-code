package module05.lesson11.example04;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static void processAll(Deque<String> tasks) {
        while (!tasks.isEmpty()) {
            System.out.println("Processing: " + tasks.pollFirst());
        }
    }

    public static void main(String[] args) {
        Deque<String> tasks = new ArrayDeque<>();
        tasks.offerLast("Review Nur's enrollment");
        tasks.offerLast("Review Subu's enrollment");
        processAll(tasks);
        System.out.println(tasks.isEmpty());
    }
}
