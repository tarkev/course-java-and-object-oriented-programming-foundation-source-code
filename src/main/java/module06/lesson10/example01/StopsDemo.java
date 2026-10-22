package module06.lesson10.example01;

import java.util.ArrayDeque;
import java.util.Deque;

public class StopsDemo {

    public static void main(String[] args) {
        Deque<String> stops = new ArrayDeque<>();
        stops.push("Gulshan");
        stops.push("Banani");
        stops.offerLast("Mirpur");
        System.out.println(stops.pop() + " " + stops.pollLast() + " " + stops.peek());
    }
}
