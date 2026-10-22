package module07.lesson12.example02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        try (ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> java = executor.submit(() -> loadCourse("JAVA"));
            Future<String> backend = executor.submit(() -> loadCourse("BACKEND"));

            System.out.println(java.get());
            System.out.println(backend.get());
        }
    }

    static String loadCourse(String code) {
        return "Loaded " + code;
    }
}
