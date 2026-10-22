package module07.lesson15.example11;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {

    static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        try {
            System.out.println(summary("JAVA").join());
            System.out.println(summary("DRAFT").join());
            System.out.println(summaryWithOuterFallback("DRAFT").join());
        } finally {
            executor.shutdown();
        }
    }

    static CompletableFuture<String> summary(String code) {
        CompletableFuture<String> lessonsText = loadLessons(code)
                .thenApply(lessons -> lessons.size() + " lessons ("
                        + lessons.stream().collect(Collectors.joining(", ")) + ")")
                .exceptionally(exception -> "lessons unavailable");

        return loadCourse(code).thenCombine(
                lessonsText,
                (course, text) -> course.title() + ": " + text);
    }

    static CompletableFuture<String> summaryWithOuterFallback(String code) {
        return loadCourse(code)
                .thenCombine(loadLessons(code),
                        (course, lessons) -> course.title() + ": " + lessons.size() + " lessons")
                .exceptionally(exception -> "Course unavailable");
    }

    static CompletableFuture<Course> loadCourse(String code) {
        String title = code.equals("DRAFT") ? "Draft Course" : "Java Foundation";
        return CompletableFuture.supplyAsync(() -> new Course(code, title), executor);
    }

    static CompletableFuture<List<String>> loadLessons(String code) {
        return CompletableFuture.supplyAsync(() -> {
            if (code.equals("DRAFT")) {
                throw new IllegalStateException("No lessons for " + code);
            }
            return List.of("Variables", "Loops", "Methods");
        }, executor);
    }

    record Course(String code, String title) {
    }
}
