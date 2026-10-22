// Generated from modules/10-professional-java-practices/01-organizing-java-applications-with-packages.md by tools/extract_code.py. Edit the lesson, not this file.
package module10.lesson01.example01.course;

import java.util.List;

public interface CourseRepository {

    void save(
            Course course
    );

    Course findByCode(
            CourseCode courseCode
    );

    List<Course> findAll();
}
