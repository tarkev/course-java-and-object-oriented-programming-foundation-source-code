package module11.lesson10.tests.enrollment;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.learner.LearnerId;

public final class Enrollment {

    private final EnrollmentId id;
    private final LearnerId learnerId;
    private final CourseCode courseCode;

    private EnrollmentStatus status;

    public Enrollment(
            EnrollmentId id, LearnerId learnerId, CourseCode courseCode) {
        this(id, learnerId, courseCode, EnrollmentStatus.ACTIVE);
    }

    private Enrollment(EnrollmentId id, LearnerId learnerId,
            CourseCode courseCode, EnrollmentStatus status) {
        if (id == null) {
            throw new IllegalArgumentException("Enrollment id is required.");
        }

        if (learnerId == null) {
            throw new IllegalArgumentException("Learner id is required.");
        }

        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (status == null) {
            throw new IllegalArgumentException("Enrollment status is required.");
        }

        this.id = id;
        this.learnerId = learnerId;
        this.courseCode = courseCode;
        this.status = status;
    }

    public static Enrollment restore(EnrollmentId id, LearnerId learnerId,
            CourseCode courseCode, EnrollmentStatus status) {
        return new Enrollment(id, learnerId, courseCode, status);
    }

    public void complete() {
        if (status != EnrollmentStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Only active enrollment can be completed.");
        }

        status = EnrollmentStatus.COMPLETED;
    }

    public void cancel() {
        if (status != EnrollmentStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Only active enrollment can be cancelled.");
        }

        status = EnrollmentStatus.CANCELLED;
    }

    public boolean isActive() {
        return status == EnrollmentStatus.ACTIVE;
    }

    public boolean isCompleted() {
        return status == EnrollmentStatus.COMPLETED;
    }

    public boolean isCancelled() {
        return status == EnrollmentStatus.CANCELLED;
    }

    public EnrollmentSummary summary() {
        return new EnrollmentSummary(id, learnerId, courseCode, status);
    }

    public EnrollmentId getId() {
        return id;
    }

    public LearnerId getLearnerId() {
        return learnerId;
    }

    public CourseCode getCourseCode() {
        return courseCode;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }
}
