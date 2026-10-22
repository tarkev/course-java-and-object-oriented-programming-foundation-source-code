package module10.lesson01.example02.course;

import java.util.List;

public final class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Course repository is required.");
        }

        this.repository = repository;
    }

    public void createCourse(CourseCode code, String title) {
        if (repository.findByCode(code).isPresent()) {
            throw new IllegalStateException("Course already exists: " + code.value());
        }

        repository.save(new Course(code, title));
    }

    public List<Course> findAll() {
        return repository.findAll();
    }
}
