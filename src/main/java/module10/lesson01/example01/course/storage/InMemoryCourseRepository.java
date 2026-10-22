// Generated from modules/10-professional-java-practices/01-organizing-java-applications-with-packages.md by tools/extract_code.py. Edit the lesson, not this file.
package module10.lesson01.example01.course.storage;

import module10.lesson01.example01.course.Course;
import module10.lesson01.example01.course.CourseCode;
import module10.lesson01.example01.course.CourseRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class InMemoryCourseRepository
        implements CourseRepository {

    private final Map<CourseCode, Course> courses =
            new LinkedHashMap<>();

    @Override
    public void save(
            Course course
    ) {
        courses.put(
                course.getCode(),
                course
        );
    }

    @Override
    public Course findByCode(
            CourseCode courseCode
    ) {
        return courses.get(
                courseCode
        );
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(
                courses.values()
        );
    }
}
