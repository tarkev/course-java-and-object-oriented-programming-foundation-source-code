// Generated from modules/07-modern-java/11-executors-callable-future-and-completablefuture.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson11.example01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(
            String[] args
    ) {
        ExecutorService executor =
                Executors.newFixedThreadPool(
                        4
                );

        try {
            CompletableFuture<Course> courseFuture =
                    CompletableFuture.supplyAsync(
                            () ->
                                    loadCourse(
                                            "JAVA"
                                    ),
                            executor
                    );

            CompletableFuture<Integer> countFuture =
                    CompletableFuture.supplyAsync(
                            Main::loadEnrollmentCount,
                            executor
                    );

            CompletableFuture<String> summaryFuture =
                    courseFuture.thenCombine(
                            countFuture,
                            (
                                    course,
                                    count
                            ) ->
                                    course.title()
                                    + " has "
                                    + count
                                    + " learners."
                    );

            System.out.println(
                    summaryFuture.join()
            );
        } finally {
            executor.shutdown();
        }
    }

    static Course loadCourse(
            String code
    ) {
        return new Course(
                code,
                "Java Foundation"
        );
    }

    static int loadEnrollmentCount() {
        return 120;
    }

    record Course(
            String code,
            String title
    ) {
    }
}
