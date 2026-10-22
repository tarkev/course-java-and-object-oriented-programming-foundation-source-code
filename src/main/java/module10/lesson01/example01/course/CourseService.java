// Generated from modules/10-professional-java-practices/01-organizing-java-applications-with-packages.md by tools/extract_code.py. Edit the lesson, not this file.
package module10.lesson01.example01.course;

import java.util.List;

public final class CourseService {

    private final CourseRepository repository;

    public CourseService(
            CourseRepository repository
    ) {
        if (
                repository == null
        ) {
            throw new IllegalArgumentException(
                    "Course repository is required."
            );
        }

        this.repository =
                repository;
    }

    public void createCourse(
            CourseCode code,
            String title
    ) {
        Course existing =
                repository.findByCode(
                        code
                );

        if (
                existing != null
        ) {
            throw new IllegalStateException(
                    "Course already exists."
            );
        }

        repository.save(
                new Course(
                        code,
                        title
                )
        );
    }

    public List<Course> findAll() {
        return repository.findAll();
    }
}
