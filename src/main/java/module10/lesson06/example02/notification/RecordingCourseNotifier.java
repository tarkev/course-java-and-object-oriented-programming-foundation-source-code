package module10.lesson06.example02.notification;

import module10.lesson06.example02.course.Course;

public final class RecordingCourseNotifier implements CourseNotifier {

    private int publishCount;

    @Override
    public void coursePublished(Course course) {
        publishCount++;
    }

    public int getPublishCount() {
        return publishCount;
    }
}
