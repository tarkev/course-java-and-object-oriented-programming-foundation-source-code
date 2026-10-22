package module03.lesson13.example01;

public class Main {

    public static void main(String[] args) {
        Course java = new Course();
        java.title = "Java and OOP Foundation";
        java.lessonCount = 107;

        Course spring = new Course();
        spring.title = "Backend Development with Spring Boot";
        spring.lessonCount = 60;

        java.lessonCount = 110;

        System.out.println(java.title + ": " + java.lessonCount);
        System.out.println(spring.title + ": " + spring.lessonCount);
        System.out.println("Can publish: " + spring.canBePublished());
    }
}

class Course {

    String title;
    int lessonCount;
    boolean published;

    boolean canBePublished() {
        return title != null && !title.isBlank() && lessonCount > 0;
    }
}
