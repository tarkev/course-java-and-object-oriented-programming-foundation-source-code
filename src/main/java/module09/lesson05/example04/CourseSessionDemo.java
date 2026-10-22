package module09.lesson05.example04;

public class CourseSessionDemo {

    public static void main(String[] args) {
        try (CourseSession session = new CourseSession("JAVA-OOP")) {
            session.process();
        }
    }
}
