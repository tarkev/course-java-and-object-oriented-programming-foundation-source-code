package module10.lesson06.example01.notification;

import module10.lesson06.example01.course.Course;

public final class ConsoleCourseNotifier implements CourseNotifier {

    @Override
    public void coursePublished(Course course) {
        System.out.println("Course published: " + course.getTitle());
    }
}
