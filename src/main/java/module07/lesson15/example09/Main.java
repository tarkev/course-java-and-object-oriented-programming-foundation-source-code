package module07.lesson15.example09;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            CompletableFuture<String> titleFuture =
                    CompletableFuture.supplyAsync(() -> loadTitle("JAVA"), executor);
            CompletableFuture<Integer> lessonCountFuture =
                    CompletableFuture.supplyAsync(() -> loadLessonCount("JAVA"), executor);

            CompletableFuture<String> pageFuture = titleFuture.thenCombine(
                    lessonCountFuture,
                    (title, lessonCount) -> title + ": " + lessonCount + " lessons");

            System.out.println(pageFuture.join());
        } finally {
            executor.shutdown();
        }
    }

    static String loadTitle(String courseCode) {
        return "Java Foundation";
    }

    static int loadLessonCount(String courseCode) {
        return 12;
    }
}
