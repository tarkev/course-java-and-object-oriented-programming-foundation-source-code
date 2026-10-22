package module10.lesson09.example07;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment = new Enrollment("Nur", new CourseCode("JAVA-OOP"));
        EnrollmentSummary before = enrollment.summary();

        enrollment.cancel();

        System.out.println(before);
        System.out.println(enrollment.summary());
    }
}

record CourseCode(String value) {
}

enum EnrollmentStatus {
    ACTIVE,
    CANCELLED
}

record EnrollmentSummary(
        String learner, CourseCode courseCode, EnrollmentStatus status) {
}

final class Enrollment {

    private final String learner;
    private final CourseCode courseCode;
    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;

    Enrollment(String learner, CourseCode courseCode) {
        this.learner = learner;
        this.courseCode = courseCode;
    }

    void cancel() {
        if (status != EnrollmentStatus.ACTIVE) {
            throw new IllegalStateException("Only active enrollments can be cancelled.");
        }

        status = EnrollmentStatus.CANCELLED;
    }

    EnrollmentSummary summary() {
        return new EnrollmentSummary(learner, courseCode, status);
    }
}
