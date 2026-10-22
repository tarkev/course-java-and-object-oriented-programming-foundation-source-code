package module11.lesson10.tests.enrollment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.learner.LearnerId;
import org.junit.jupiter.api.Test;

class EnrollmentTest {

    private final Enrollment enrollment = new Enrollment(
            new EnrollmentId(1001L), new LearnerId(1L),
            new CourseCode("JAVA-OOP"));

    @Test
    void newEnrollmentIsActive() {
        assertEquals(EnrollmentStatus.ACTIVE, enrollment.getStatus());
    }

    @Test
    void completedEnrollmentCannotBeCompletedAgain() {
        enrollment.complete();

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, enrollment::complete);

        assertEquals("Only active enrollment can be completed.",
                exception.getMessage());
    }

    @Test
    void cancelledEnrollmentCannotBeCompleted() {
        enrollment.cancel();

        assertThrows(IllegalStateException.class, enrollment::complete);
        assertEquals(EnrollmentStatus.CANCELLED, enrollment.getStatus());
    }

    @Test
    void completedEnrollmentCannotBeCancelled() {
        enrollment.complete();

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, enrollment::cancel);

        assertEquals("Only active enrollment can be cancelled.",
                exception.getMessage());
    }

    @Test
    void restoreRebuildsACompletedEnrollment() {
        Enrollment restored = Enrollment.restore(new EnrollmentId(1001L),
                new LearnerId(1L), new CourseCode("JAVA-OOP"),
                EnrollmentStatus.COMPLETED);

        assertEquals(EnrollmentStatus.COMPLETED, restored.getStatus());
    }
}
