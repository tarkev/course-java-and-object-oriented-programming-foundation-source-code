package module10.lesson07.example01.course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    Optional<Course> findByCode(CourseCode courseCode);

    void save(Course course);

    List<Course> findAll();
}
