package module05.lesson10.example17;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static void printQueue(Queue<String> queue) {
        for (String item : queue) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("Enroll Subu");
        queue.offer("Enroll Sumu");
        printQueue(queue);
        System.out.println(queue.size());
    }
}
