// Generated from modules/07-modern-java/12-virtual-threads-and-concurrent-collections.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson12.example02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(
            String[] args
    ) throws InterruptedException {
        BlockingQueue<String> queue =
                new ArrayBlockingQueue<>(
                        2
                );

        Thread producer =
                Thread.startVirtualThread(
                        () ->
                                produce(
                                        queue
                                )
                );

        Thread consumer =
                Thread.startVirtualThread(
                        () ->
                                consume(
                                        queue
                                )
                );

        producer.join();
        consumer.join();
    }

    static void produce(
            BlockingQueue<String> queue
    ) {
        try {
            for (
                    int i = 1;
                    i <= 5;
                    i++
            ) {
                String task =
                        "Task-"
                        + i;

                queue.put(
                        task
                );

                System.out.println(
                        "Produced "
                        + task
                );
            }
        } catch (
                InterruptedException exception
        ) {
            Thread.currentThread()
                    .interrupt();
        }
    }

    static void consume(
            BlockingQueue<String> queue
    ) {
        try {
            for (
                    int i = 1;
                    i <= 5;
                    i++
            ) {
                String task =
                        queue.take();

                System.out.println(
                        "Consumed "
                        + task
                );
            }
        } catch (
                InterruptedException exception
        ) {
            Thread.currentThread()
                    .interrupt();
        }
    }
}
