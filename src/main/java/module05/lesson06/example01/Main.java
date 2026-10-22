package module05.lesson06.example01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<String> courses = new ArrayDeque<>();
        courses.addLast("Java");
        courses.addLast("Backend");
        courses.addFirst("Programming Fundamentals");

        System.out.println("First: " + courses.peekFirst());
        System.out.println("Last: " + courses.peekLast());
        System.out.println("Removed first: " + courses.pollFirst());
        System.out.println("Removed last: " + courses.pollLast());
    }
}
