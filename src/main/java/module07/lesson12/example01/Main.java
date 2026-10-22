// Generated from modules/07-modern-java/12-virtual-threads-and-concurrent-collections.md by tools/extract_code.py. Edit the lesson, not this file.
package module07.lesson12.example01;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(
            String[] args
    ) throws Exception {
        try (
                var executor =
                        Executors
                                .newVirtualThreadPerTaskExecutor()
        ) {
            Future<String> java =
                    executor.submit(
                            () ->
                                    loadCourse(
                                            "JAVA"
                                    )
                    );

            Future<String> backend =
                    executor.submit(
                            () ->
                                    loadCourse(
                                            "BACKEND"
                                    )
                    );

            System.out.println(
                    java.get()
            );

            System.out.println(
                    backend.get()
            );
        }
    }

    static String loadCourse(
            String code
    ) {
        return "Loaded "
                + code;
    }
}
