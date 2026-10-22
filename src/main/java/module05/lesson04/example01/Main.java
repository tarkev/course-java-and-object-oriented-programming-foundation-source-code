package module05.lesson04.example01;

public class Main {

    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();

        Course javaCourse =
                new Course(new CourseCode("java-oop"), "Java and OOP Foundation");
        Course backendCourse =
                new Course(new CourseCode("backend"), "Backend Development");
        Course duplicateJavaCourse =
                new Course(new CourseCode("JAVA-OOP"), "Another Java Course");

        System.out.println(
                "Java registered: " + catalog.register(javaCourse));
        System.out.println(
                "Backend registered: " + catalog.register(backendCourse));
        System.out.println(
                "Duplicate registered: " + catalog.register(duplicateJavaCourse));
        System.out.println("Course count: " + catalog.getCourseCount());

        Course found = catalog.findByCode(new CourseCode("Java-Oop"));

        if (found != null) {
            System.out.println("Found: " + found.getTitle());
        }

        System.out.println();

        catalog.printCourses();

        boolean removed = catalog.remove(new CourseCode("BACKEND"));

        System.out.println();
        System.out.println("Backend removed: " + removed);
        System.out.println("Course count: " + catalog.getCourseCount());
    }
}
