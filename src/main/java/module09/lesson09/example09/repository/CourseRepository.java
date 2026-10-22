package module09.lesson09.example09.repository;

import module09.lesson09.example09.course.Course;
import module09.lesson09.example09.course.CourseCode;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    // Creates the Course, or replaces the stored version.
    void save(Course course);

    // Empty when no Course is stored under this code.
    Optional<Course> findByCode(CourseCode courseCode);

    List<Course> findAll();

    // true if a Course was deleted, false if none was stored.
    boolean deleteByCode(CourseCode courseCode);
}
