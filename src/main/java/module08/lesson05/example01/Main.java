package module08.lesson05.example01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            loadCourse("JAVA-OOP");
        } catch (CourseRepositoryException exception) {
            System.out.println("Message: " + exception.getMessage());
            System.out.println("Cause: " + exception.getCause());

            exception.printStackTrace();
        }
    }

    static void loadCourse(String courseCode) {
        try {
            readCourseFile(courseCode);
        } catch (IOException exception) {
            throw new CourseRepositoryException(
                    "Could not load course " + courseCode + ".", exception);
        }
    }

    static void readCourseFile(String courseCode) throws IOException {
        throw new IOException("Disk is not ready.");
    }
}
