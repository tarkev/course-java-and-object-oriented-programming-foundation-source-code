// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01.course;

public enum CourseStatus {

    DRAFT,
    REVIEW,
    PUBLISHED,
    ARCHIVED;

    public boolean canTransitionTo(
            CourseStatus target
    ) {
        if (
                target == null
        ) {
            return false;
        }

        return switch (this) {
            case DRAFT ->
                    target == REVIEW;

            case REVIEW ->
                    target == DRAFT
                    || target == PUBLISHED;

            case PUBLISHED ->
                    target == ARCHIVED;

            case ARCHIVED ->
                    false;
        };
    }
}
