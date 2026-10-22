package module11.lesson06.example01.course;

import java.util.List;

public final class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Course repository is required.");
        }

        this.repository = repository;
    }

    public void createCourse(
            CourseCode courseCode, String title, long priceInPaisa) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        if (repository.findByCode(courseCode).isPresent()) {
            throw new DuplicateCourseException(courseCode);
        }

        Course course = new Course(courseCode, title, priceInPaisa);
        repository.save(course);
    }

    public void addLesson(CourseCode courseCode, Lesson lesson) {
        Course course = requireCourse(courseCode);
        course.addLesson(lesson);
        repository.save(course);
    }

    public void publishCourse(CourseCode courseCode) {
        Course course = requireCourse(courseCode);
        course.publish();
        repository.save(course);
    }

    public void archiveCourse(CourseCode courseCode) {
        Course course = requireCourse(courseCode);
        course.archive();
        repository.save(course);
    }

    public CourseSummary findCourse(CourseCode courseCode) {
        return requireCourse(courseCode).summary();
    }

    public List<CourseSummary> findAllCourses() {
        return repository.findAll().stream().map(Course::summary).toList();
    }

    private Course requireCourse(CourseCode courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Course code is required.");
        }

        return repository.findByCode(courseCode)
                .orElseThrow(() -> new CourseNotFoundException(courseCode));
    }
}
