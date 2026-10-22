package module05.lesson06.example03;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        history.push("Created course");
        history.push("Changed title");
        history.push("Published course");

        undo(history);
        undo(history);
    }

    private static void undo(Deque<String> history) {
        String action = history.pollFirst();

        if (action == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        System.out.println("Undo: " + action);
    }
}
