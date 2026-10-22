package module08.lesson08.example12;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            loadCourse(new CourseCode("JAVA-OOP"));
        } catch (CourseRepositoryException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }

    static Course loadCourse(CourseCode code) {
        try {
            return queryCourse(code);
        } catch (SQLException exception) {
            throw new CourseRepositoryException(
                    "Could not load course " + code + ".", exception);
        }
    }

    // Stands in for real JDBC code, which this course does not cover.
    static Course queryCourse(CourseCode code) throws SQLException {
        throw new SQLException("Connection refused");
    }
}

record CourseCode(String value) {

    @Override
    public String toString() {
        return value;
    }
}

record Course(CourseCode code, String title) {
}

class CourseRepositoryException extends RuntimeException {

    CourseRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
