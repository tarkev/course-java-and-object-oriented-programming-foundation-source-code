package module10.lesson11.tests.course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    Optional<Course> findByCode(CourseCode courseCode);

    void save(Course course);

    List<Course> findAll();
}
