package module06.lesson10.example02;

import java.util.PriorityQueue;

public class TopDistancesDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int distance : new int[] {700, 200, 900, 400, 800}) {
            heap.offer(distance);
            if (heap.size() > 3) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
