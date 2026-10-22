package module11.lesson06.example01.enrollment;

import module11.lesson06.example01.course.CourseCode;
import module11.lesson06.example01.learner.LearnerId;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    void save(Enrollment enrollment);

    Optional<Enrollment> findById(EnrollmentId enrollmentId);

    boolean existsByLearnerAndCourse(
            LearnerId learnerId, CourseCode courseCode);

    List<Enrollment> findAll();
}
