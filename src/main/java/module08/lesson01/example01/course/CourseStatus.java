package module08.lesson01.example01.course;

public enum CourseStatus {

    DRAFT, REVIEW, PUBLISHED, ARCHIVED;

    public boolean isEditable() {
        return this == DRAFT || this == REVIEW;
    }

    public boolean isPubliclyVisible() {
        return this == PUBLISHED;
    }
}
