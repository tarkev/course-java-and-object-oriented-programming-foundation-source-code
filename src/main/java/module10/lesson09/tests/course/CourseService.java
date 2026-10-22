package module10.lesson09.tests.course;

import java.util.List;

public final class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Course repository is required.");
        }

        this.repository = repository;
    }

    public void createCourse(CourseCode code, String title, long priceInPaisa) {
        if (repository.findByCode(code).isPresent()) {
            throw new DuplicateCourseException(code);
        }

        repository.save(new Course(code, title, priceInPaisa));
    }

    public void publishCourse(CourseCode code) {
        Course course = requireCourse(code);
        course.publish();
        repository.save(course);
    }

    public List<CourseSummary> findAll() {
        return repository.findAll().stream().map(Course::summary).toList();
    }

    private Course requireCourse(CourseCode code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new CourseNotFoundException(code));
    }
}
