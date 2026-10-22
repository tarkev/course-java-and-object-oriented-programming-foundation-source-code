package module07.lesson15.example03;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<EnrollmentKey, Enrollment> enrollments = new HashMap<>();
        EnrollmentKey key = new EnrollmentKey(new LearnerId(7), new CourseCode("JAVA"));
        enrollments.put(key, new Enrollment(key));

        EnrollmentKey lookup = new EnrollmentKey(new LearnerId(7), new CourseCode("JAVA"));
        Enrollment enrollment = enrollments.get(lookup);
        enrollment.complete();

        System.out.println(lookup == key);
        System.out.println(enrollment.status());
    }

    record LearnerId(long value) {
    }

    record CourseCode(String value) {
    }

    record EnrollmentKey(LearnerId learnerId, CourseCode courseCode) {
    }

    static final class Enrollment {

        private final EnrollmentKey key;
        private String status = "ACTIVE";

        Enrollment(EnrollmentKey key) {
            this.key = key;
        }

        void complete() {
            status = "COMPLETED";
        }

        String status() {
            return status;
        }
    }
}
