// Generated from modules/06-algorithms-and-problem-solving-with-java/06-using-stacks-queues-and-deques-in-algorithms.md by tools/extract_code.py. Edit the lesson, not this file.
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
