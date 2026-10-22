package module03.lesson14.example01;

import module03.lesson14.example01.course.CourseFee;
import module03.lesson14.example01.course.CourseLesson;
import module03.lesson14.example01.course.TrainingCourse;

public class Main {

    public static void main(String[] args) {
        CourseFee base = new CourseFee(4000, "bdt");
        CourseFee withLab = base.plus(new CourseFee(500, "BDT"));
        CourseFee launchPrice = withLab.discountedBy(20);
        System.out.println(base + " -> " + withLab + " -> " + launchPrice);
        System.out.println(launchPrice.equals(new CourseFee(3600, "BDT")));

        TrainingCourse course =
                new TrainingCourse("JAVA-OOP", "Java OOP Basics", withLab);
        System.out.println("Publish empty: " + course.publish());
        System.out.println(
                course.addLesson(new CourseLesson("L1", "Classes", 30)));
        System.out.println(
                course.addLesson(new CourseLesson("L2", "Constructors", 25)));
        System.out.println("Duplicate: "
                + course.addLesson(new CourseLesson("L1", "Objects", 20)));
        System.out.println(course.changeFee(launchPrice));
        System.out.println("Publish: " + course.publish());
        System.out.println("Add after publish: "
                + course.addLesson(new CourseLesson("L3", "this", 15)));
        System.out.println("Fee after publish: " + course.changeFee(base));

        CourseLesson[] copy = course.getLessons();
        copy[0] = null;
        System.out.println(course);
    }
}
