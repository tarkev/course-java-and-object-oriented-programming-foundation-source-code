package module10.lesson04.example03.course;

public class SnapshotDemo {

    public static void main(String[] args) {
        Course course = new Course(new CourseCode("java-oop"), "Java Basics");
        CourseSummary before = course.summary();

        course.changeTitle("Java and OOP Foundation");
        course.publish();

        CourseSummary after = course.summary();

        System.out.println(before);
        System.out.println(after);
        System.out.println(before.equals(after));
        System.out.println(before.code().equals(after.code()));
    }
}
