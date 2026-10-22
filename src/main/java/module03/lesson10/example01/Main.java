// Generated from modules/03-object-oriented-programming-foundations/10-packages-and-organizing-java-code.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson10.example01;

import module03.lesson10.example01.course.Course;
import module03.lesson10.example01.course.CourseCode;
import module03.lesson10.example01.enrollment.Enrollment;
import module03.lesson10.example01.learner.Learner;

public class Main {

    public static void main(String[] args) {
        Course course = new Course(
                new CourseCode("java-foundation"), "Java and OOP Foundation", 20);

        course.publish();

        Learner nur = new Learner(1L, "Nur");

        Enrollment enrollment = new Enrollment(nur, course);

        enrollment.completeLessons(8);

        System.out.println("Learner: " + enrollment.getLearner().getName());

        System.out.println("Course: " + enrollment.getCourse().getTitle());

        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");
    }
}
