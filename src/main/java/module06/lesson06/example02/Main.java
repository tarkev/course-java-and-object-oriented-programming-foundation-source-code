// Generated from modules/06-algorithms-and-problem-solving-with-java/06-using-stacks-queues-and-deques-in-algorithms.md by tools/extract_code.py. Edit the lesson, not this file.
package module06.lesson06.example02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> requests = new ArrayDeque<>();

        requests.offer("Enroll Sakib");

        requests.offer("Enroll Subu");

        requests.offer("Enroll Sumu");

        processAll(requests);
    }

    static void processAll(Queue<String> requests) {
        while (!requests.isEmpty()) {
            String request = requests.poll();

            System.out.println(request);
        }
    }
}
