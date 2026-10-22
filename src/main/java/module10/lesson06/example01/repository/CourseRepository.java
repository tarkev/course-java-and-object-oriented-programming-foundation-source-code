package module10.lesson06.example01.repository;

import module10.lesson06.example01.course.Course;
import module10.lesson06.example01.course.CourseCode;

import java.util.Optional;

public interface CourseRepository {

    Optional<Course> findByCode(CourseCode code);

    void save(Course course);
}
