package module11.lesson06.example01.enrollment;

public final class EnrollmentNotFoundException extends RuntimeException {

    public EnrollmentNotFoundException(EnrollmentId enrollmentId) {
        super("Enrollment not found: " + enrollmentId + ".");
    }
}
