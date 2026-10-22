package module03.lesson06.example01;

public class Main {

    public static void main(String[] args) {
        System.out.println(Course.getTotalCoursesCreated());

        new Course("Java and OOP Foundation", 20);
        new Course("Backend Development", 30);

        System.out.println(Course.getTotalCoursesCreated());
    }
}
