package module11.lesson06.example01.course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void save(Course course);

    Optional<Course> findByCode(CourseCode courseCode);

    List<Course> findAll();
}
