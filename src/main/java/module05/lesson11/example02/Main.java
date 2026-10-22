package module05.lesson11.example02;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> values = new ArrayDeque<>();
        values.offerLast(10);
        values.offerLast(20);
        values.offerLast(30);
        values.offerLast(40);

        System.out.println(values.pollFirst());
        System.out.println(values.pollLast());
        System.out.println(values);
    }
}
