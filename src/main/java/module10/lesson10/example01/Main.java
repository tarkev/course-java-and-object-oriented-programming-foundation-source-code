package module10.lesson10.example01;

public class Main {

    public static void main(String[] args) {
        Enrollment enrollment = new Enrollment();
        enrollment.recordProgress(60);

        try {
            enrollment.complete();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

        enrollment.recordProgress(100);
        enrollment.complete();
        System.out.println(enrollment.getStatus());
    }
}

enum EnrollmentStatus {
    ACTIVE,
    COMPLETED
}

final class Enrollment {

    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;
    private int progress;

    void recordProgress(int percent) {
        if (percent < progress || percent > 100) {
            throw new IllegalArgumentException("Invalid progress: " + percent);
        }

        progress = percent;
    }

    void complete() {
        if (status != EnrollmentStatus.ACTIVE) {
            throw new IllegalStateException("Only active enrollments can be completed.");
        }

        if (progress < 100) {
            throw new IllegalStateException("Progress must reach 100 percent.");
        }

        status = EnrollmentStatus.COMPLETED;
    }

    EnrollmentStatus getStatus() {
        return status;
    }
}
