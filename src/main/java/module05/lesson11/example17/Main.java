package module05.lesson11.example17;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> courses = new ArrayDeque<>();
        courses.offer("Java");
        courses.offer("Backend");
        courses.offer("System Design");

        while (!courses.isEmpty()) {
            System.out.println(courses.poll());
        }
    }
}
