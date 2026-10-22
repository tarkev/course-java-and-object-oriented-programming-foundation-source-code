// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01.repository;

public final class CourseRepositoryException
        extends RuntimeException {

    public CourseRepositoryException(
            String message
    ) {
        super(
                message
        );
    }

    public CourseRepositoryException(
            String message,
            Throwable cause
    ) {
        super(
                message,
                cause
        );
    }
}
