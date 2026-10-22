package module08.lesson09.example01;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("Java and OOP Foundation");
        course.changeStatus(CourseStatus.REVIEW);
        System.out.println("Status: " + course.getStatus());

        try {
            course.changeStatus(CourseStatus.ARCHIVED);
        } catch (InvalidCourseTransitionException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Current: " + exception.getCurrentStatus()
                    + ", target: " + exception.getTargetStatus());
        }

        try {
            course.changeStatus(null);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

enum CourseStatus {

    DRAFT, REVIEW, PUBLISHED, ARCHIVED;

    public boolean canTransitionTo(CourseStatus target) {
        return switch (this) {
            case DRAFT -> target == REVIEW;
            case REVIEW -> target == DRAFT || target == PUBLISHED;
            case PUBLISHED -> target == ARCHIVED;
            case ARCHIVED -> false;
        };
    }
}

final class InvalidCourseTransitionException extends RuntimeException {

    private final CourseStatus currentStatus;
    private final CourseStatus targetStatus;

    public InvalidCourseTransitionException(
            CourseStatus currentStatus, CourseStatus targetStatus) {
        super("Course cannot transition from "
                + currentStatus + " to " + targetStatus + ".");
        this.currentStatus = currentStatus;
        this.targetStatus = targetStatus;
    }

    public CourseStatus getCurrentStatus() {
        return currentStatus;
    }

    public CourseStatus getTargetStatus() {
        return targetStatus;
    }
}

final class Course {

    private final String title;
    private CourseStatus status = CourseStatus.DRAFT;

    public Course(String title) {
        this.title = title;
    }

    public void changeStatus(CourseStatus targetStatus) {
        if (targetStatus == null) {
            throw new IllegalArgumentException("Target status is required.");
        }

        if (!status.canTransitionTo(targetStatus)) {
            throw new InvalidCourseTransitionException(status, targetStatus);
        }

        status = targetStatus;
    }

    public CourseStatus getStatus() {
        return status;
    }
}
