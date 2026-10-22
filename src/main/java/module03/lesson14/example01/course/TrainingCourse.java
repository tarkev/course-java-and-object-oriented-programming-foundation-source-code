package module03.lesson14.example01.course;

import java.util.Arrays;

public class TrainingCourse {

    public static final int MAX_LESSONS = 3;

    private final String code;
    private final String title;
    private final CourseLesson[] lessons = new CourseLesson[MAX_LESSONS];
    private CourseFee fee;
    private int lessonCount;
    private boolean published;

    public TrainingCourse(String code, String title, CourseFee fee) {
        if (code == null || code.isBlank() || title == null || title.isBlank()) {
            throw new IllegalArgumentException("Code and title are required.");
        }

        if (fee == null) {
            throw new IllegalArgumentException("Course fee is required.");
        }

        this.code = code.strip();
        this.title = title.strip();
        this.fee = fee;
    }

    public boolean addLesson(CourseLesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson is required.");
        }

        if (published || lessonCount == MAX_LESSONS) {
            return false;
        }

        for (int i = 0; i < lessonCount; i++) {
            if (lessons[i].equals(lesson)) {
                return false;
            }
        }

        lessons[lessonCount] = lesson;
        lessonCount++;
        return true;
    }

    public boolean publish() {
        if (published || lessonCount == 0) {
            return false;
        }

        published = true;
        return true;
    }

    public boolean changeFee(CourseFee newFee) {
        if (newFee == null) {
            throw new IllegalArgumentException("Course fee is required.");
        }

        if (published) {
            return false;
        }

        fee = newFee;
        return true;
    }

    public int totalMinutes() {
        int total = 0;

        for (int i = 0; i < lessonCount; i++) {
            total += lessons[i].getMinutes();
        }

        return total;
    }

    public CourseLesson[] getLessons() {
        return Arrays.copyOf(lessons, lessonCount);
    }

    @Override
    public String toString() {
        String status = "draft";

        if (published) {
            status = "published";
        }

        return code + " " + title + " [" + lessonCount + " lessons, "
                + totalMinutes() + " min, " + fee + ", " + status + "]";
    }
}
