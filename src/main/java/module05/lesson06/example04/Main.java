package module05.lesson06.example04;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final int MAX_RECENT = 3;

    public static void main(String[] args) {
        Deque<String> recent = new ArrayDeque<>();
        view(recent, "Java");
        view(recent, "Backend");
        view(recent, "System Design");
        view(recent, "Algorithms");

        for (String course : recent) {
            System.out.println(course);
        }
    }

    private static void view(Deque<String> recent, String course) {
        recent.addFirst(course);

        if (recent.size() > MAX_RECENT) {
            recent.removeLast();
        }
    }
}
