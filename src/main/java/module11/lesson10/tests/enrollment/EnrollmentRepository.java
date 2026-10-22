package module11.lesson10.tests.enrollment;

import module11.lesson10.tests.course.CourseCode;
import module11.lesson10.tests.learner.LearnerId;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    void save(Enrollment enrollment);

    Optional<Enrollment> findById(EnrollmentId enrollmentId);

    boolean existsByLearnerAndCourse(
            LearnerId learnerId, CourseCode courseCode);

    List<Enrollment> findAll();
}
