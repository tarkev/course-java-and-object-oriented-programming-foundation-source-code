package module09.lesson07.example01.course;

public enum CourseStatus {

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
