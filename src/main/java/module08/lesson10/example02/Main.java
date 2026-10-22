package module08.lesson10.example02;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        EnrollmentService service = new EnrollmentService();
        System.out.println(handleEnrollment(service, "Sakib", "JAVA-OOP"));
        System.out.println(handleEnrollment(service, "Sakib", "JAVA-OOP"));
        System.out.println(handleEnrollment(service, "Nur", "KAFKA"));
        System.out.println(handleEnrollment(service, "Subu", "JAVA-OOP"));
    }

    static String handleEnrollment(
            EnrollmentService service, String learner, String courseCode) {
        try {
            service.enroll(learner, courseCode);
            return learner + " is enrolled in " + courseCode + ".";
        } catch (EnrollmentException exception) {
            return switch (exception.getCode()) {
                case ALREADY_ENROLLED -> "You are already enrolled in this course.";
                case COURSE_NOT_AVAILABLE -> "This course is not open for enrollment.";
                case LEARNER_SUSPENDED -> "Your account is suspended. Please contact support.";
            };
        }
    }
}

enum EnrollmentErrorCode {
    ALREADY_ENROLLED, COURSE_NOT_AVAILABLE, LEARNER_SUSPENDED
}

final class EnrollmentException extends RuntimeException {

    private final EnrollmentErrorCode code;

    public EnrollmentException(EnrollmentErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public EnrollmentErrorCode getCode() {
        return code;
    }
}

final class EnrollmentService {

    private final Set<String> openCourses = Set.of("JAVA-OOP", "SPRING-BOOT");
    private final Set<String> suspendedLearners = Set.of("Subu");
    private final Set<String> enrollments = new HashSet<>();

    public void enroll(String learner, String courseCode) {
        if (suspendedLearners.contains(learner)) {
            throw new EnrollmentException(EnrollmentErrorCode.LEARNER_SUSPENDED,
                    "Learner " + learner + " is suspended.");
        }

        if (!openCourses.contains(courseCode)) {
            throw new EnrollmentException(EnrollmentErrorCode.COURSE_NOT_AVAILABLE,
                    "Course " + courseCode + " is not open for enrollment.");
        }

        if (!enrollments.add(learner + ":" + courseCode)) {
            throw new EnrollmentException(EnrollmentErrorCode.ALREADY_ENROLLED,
                    learner + " is already enrolled in " + courseCode + ".");
        }
    }
}
