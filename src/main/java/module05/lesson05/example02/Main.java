package module05.lesson05.example02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> enrollmentRequests = new ArrayDeque<>();
        submit(enrollmentRequests, "Sakib");
        submit(enrollmentRequests, "Subu");
        submit(enrollmentRequests, "Sumu");

        System.out.println("Waiting: " + enrollmentRequests.size());

        processNext(enrollmentRequests);
        processNext(enrollmentRequests);

        System.out.println("Next learner: " + enrollmentRequests.peek());
    }

    private static void submit(Queue<String> requests, String learner) {
        if (learner == null || learner.isBlank()) {
            return;
        }

        requests.offer(learner.strip());
    }

    private static void processNext(Queue<String> requests) {
        String learner = requests.poll();

        if (learner == null) {
            System.out.println("No enrollment request.");
            return;
        }

        System.out.println("Processing enrollment for " + learner);
    }
}
