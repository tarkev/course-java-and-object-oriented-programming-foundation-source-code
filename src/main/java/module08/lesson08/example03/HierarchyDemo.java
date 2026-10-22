package module08.lesson08.example03;

class EnrollmentException extends RuntimeException {

    EnrollmentException(String message) {
        super(message);
    }
}

class CourseFullException extends EnrollmentException {

    CourseFullException(String message) {
        super(message);
    }
}

public class HierarchyDemo {

    static void enroll(String course) {
        if (course.equals("SQL")) {
            throw new CourseFullException("SQL is full.");
        }
        if (course.equals("GO")) {
            throw new EnrollmentException("GO is closed.");
        }
        System.out.println("Enrolled in " + course);
    }

    public static void main(String[] args) {
        String[] courses = {"JAVA", "SQL", "GO"};

        for (String course : courses) {
            try {
                enroll(course);
            } catch (CourseFullException exception) {
                System.out.println("Waitlist: " + exception.getMessage());
            } catch (EnrollmentException exception) {
                System.out.println("Rejected: " + exception.getMessage());
            }
        }
    }
}
