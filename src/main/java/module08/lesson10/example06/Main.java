package module08.lesson10.example06;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        EnrollmentService service = new EnrollmentService();
        System.out.println(service.enroll("enroll-req-7821", "Nur", "JAVA-OOP"));
        System.out.println(service.enroll("enroll-req-7821", "Nur", "JAVA-OOP"));

        try {
            service.enroll("enroll-req-7821", "Nur", "SPRING-BOOT");
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

record EnrollmentRequest(String learner, String courseCode) {
}

record StoredResult(EnrollmentRequest request, String enrollmentId) {
}

final class EnrollmentService {

    private final Map<String, StoredResult> resultsByKey = new HashMap<>();
    private int nextId = 1;

    public String enroll(String key, String learner, String courseCode) {
        EnrollmentRequest request = new EnrollmentRequest(learner, courseCode);
        StoredResult stored = resultsByKey.get(key);

        if (stored != null) {
            if (!stored.request().equals(request)) {
                throw new IllegalStateException("Idempotency key " + key
                        + " was already used for a different request.");
            }

            return stored.enrollmentId();
        }

        String enrollmentId = "ENR-" + nextId++;
        resultsByKey.put(key, new StoredResult(request, enrollmentId));
        return enrollmentId;
    }
}
