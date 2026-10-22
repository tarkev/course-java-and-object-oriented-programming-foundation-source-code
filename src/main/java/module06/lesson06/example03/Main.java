package module06.lesson06.example03;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        visit(history, "/courses");
        visit(history, "/courses/java");
        visit(history, "/courses/java/lesson-1");

        System.out.println("Current: " + history.peek());
        history.pop();
        System.out.println("Back to: " + history.peek());
    }

    static void visit(Deque<String> history, String page) {
        history.push(page);
    }
}
