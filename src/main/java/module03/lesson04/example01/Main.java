package module03.lesson04.example01;

public class Main {

    public static void main(String[] args) {
        Course freeCourse = new Course("Java Fundamentals", 20);
        Course paidCourse = new Course("Backend Development", 30, 799_000L);

        paidCourse.changeTitle("Backend Development with Spring Boot");
        paidCourse.publish();

        System.out.println(freeCourse.title);
        System.out.println(freeCourse.priceInPaisa);
        System.out.println(paidCourse.title);
        System.out.println(paidCourse.published);
    }
}
