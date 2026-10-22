package module08.lesson10.example07;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BatchResult<String> result = new BatchResult<>(1, List.of(
                new BatchFailure<>("", "INVALID_CODE",
                        "Course code is required.", false),
                new BatchFailure<>("SPRING-BOOT", "STORAGE_TIMEOUT",
                        "Storage did not respond.", true)));

        for (BatchFailure<String> failure : result.failures()) {
            String action = failure.retryable() ? "retry later" : "fix the data";
            System.out.println("[" + failure.item() + "] "
                    + failure.code() + " → " + action);
        }

        System.out.println("Imported: " + result.successCount());
        System.out.println("Worth retrying: " + result.retryableFailures().size());
    }
}

record BatchFailure<T>(T item, String code, String message, boolean retryable) {
}

record BatchResult<T>(int successCount, List<BatchFailure<T>> failures) {

    public BatchResult {
        failures = failures == null ? List.of() : List.copyOf(failures);
    }

    public List<BatchFailure<T>> retryableFailures() {
        return failures.stream().filter(BatchFailure::retryable).toList();
    }
}
