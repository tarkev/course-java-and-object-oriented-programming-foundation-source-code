package module10.lesson06.example02.course;

import module10.lesson06.example02.notification.CourseNotifier;
import module10.lesson06.example02.repository.CourseRepository;

import java.util.Objects;

public final class CourseService {

    private final CourseRepository repository;
    private final CourseNotifier notifier;

    public CourseService(CourseRepository repository, CourseNotifier notifier) {
        this.repository = Objects.requireNonNull(repository);
        this.notifier = Objects.requireNonNull(notifier);
    }

    public void publish(CourseCode code) {
        Course course = repository.findByCode(code)
                .orElseThrow(() -> new IllegalStateException(
                        "Course not found: " + code.value()));

        course.publish();
        repository.save(course);
        notifier.coursePublished(course);
    }
}
