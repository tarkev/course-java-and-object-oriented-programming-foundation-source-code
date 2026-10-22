// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01.repository;

import module09.lesson07.example01.course.Course;
import module09.lesson07.example01.course.CourseCode;

import java.util.List;

public interface CourseRepository {

    void save(
            Course course
    );

    Course findByCode(
            CourseCode courseCode
    );

    List<Course> findAll();

    boolean deleteByCode(
            CourseCode courseCode
    );
}
