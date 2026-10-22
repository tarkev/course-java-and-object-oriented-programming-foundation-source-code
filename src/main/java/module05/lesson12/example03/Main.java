package module05.lesson12.example03;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static String undo(Deque<String> history) {
        String action = history.pollFirst();
        if (action == null) {
            return "Nothing to undo";
        }
        return action;
    }

    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        history.push("Add lesson");
        history.push("Rename lesson");

        System.out.println(undo(history));
        System.out.println(undo(history));
        System.out.println(undo(history));
    }
}
