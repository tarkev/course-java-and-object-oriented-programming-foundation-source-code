package module05.lesson10.example06;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDemo {

    public static void main(String[] args) {
        Deque<String> pages = new ArrayDeque<>();
        pages.push("Home");
        pages.push("Search");
        pages.push("Book");
        System.out.println(pages.pop());
        System.out.println(pages.peek());
        pages.offerLast("Help");
        System.out.println(pages);
    }
}
