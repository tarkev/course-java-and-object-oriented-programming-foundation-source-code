package module05.lesson11.example01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> values = new ArrayDeque<>();
        values.offerLast(20);
        values.offerFirst(10);
        values.offerLast(30);

        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
