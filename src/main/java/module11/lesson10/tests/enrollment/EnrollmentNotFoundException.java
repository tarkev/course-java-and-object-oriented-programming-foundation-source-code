package module11.lesson10.tests.enrollment;

public final class EnrollmentNotFoundException extends RuntimeException {

    public EnrollmentNotFoundException(EnrollmentId enrollmentId) {
        super("Enrollment not found: " + enrollmentId + ".");
    }
}
