package module11.lesson10.tests.enrollment;

public final class DuplicateEnrollmentIdException extends RuntimeException {

    public DuplicateEnrollmentIdException(EnrollmentId enrollmentId) {
        super("Enrollment id already exists: " + enrollmentId + ".");
    }
}
