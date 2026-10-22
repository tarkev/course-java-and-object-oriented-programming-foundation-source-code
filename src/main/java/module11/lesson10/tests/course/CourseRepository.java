package module11.lesson10.tests.course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void save(Course course);

    Optional<Course> findByCode(CourseCode courseCode);

    List<Course> findAll();
}
