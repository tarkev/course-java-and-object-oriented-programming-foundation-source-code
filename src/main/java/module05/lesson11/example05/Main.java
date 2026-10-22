package module05.lesson11.example05;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static void addRecent(Deque<String> recent, String item) {
        recent.offerFirst(item);
        if (recent.size() > 3) {
            recent.pollLast();
        }
    }

    public static void main(String[] args) {
        Deque<String> recent = new ArrayDeque<>();
        addRecent(recent, "Generics");
        addRecent(recent, "List");
        addRecent(recent, "Set");
        addRecent(recent, "Map");
        System.out.println(recent);
    }
}
