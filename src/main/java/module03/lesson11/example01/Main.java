// Generated from modules/03-object-oriented-programming-foundations/11-project-build-a-course-enrollment-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module03.lesson11.example01;

import module03.lesson11.example01.course.Course;
import module03.lesson11.example01.course.CourseCode;
import module03.lesson11.example01.enrollment.Enrollment;
import module03.lesson11.example01.learner.Learner;

public class Main {

    public static void main(String[] args) {
        Course javaCourse =
                new Course(new CourseCode("java-foundation"), "Java Foundation", 20);

        boolean titleChanged =
                javaCourse.changeTitle("Java and OOP Foundation");

        boolean published = javaCourse.publish();

        Learner nur = new Learner(1L, "Nur", "NUR@EXAMPLE.COM");

        Enrollment enrollment = new Enrollment(nur, javaCourse);

        boolean firstUpdate = enrollment.completeLessons(5);

        boolean secondUpdate = enrollment.completeLesson();

        boolean invalidUpdate = enrollment.completeLessons(100);

        System.out.println("Title changed: " + titleChanged);

        System.out.println("Course published: " + published);

        System.out.println(
                "Total course objects created: " + Course.getTotalCoursesCreated());

        System.out.println("Course: " + javaCourse);

        System.out.println("Learner: " + nur);

        System.out.println("Enrollment: " + enrollment);

        System.out.println("First progress update: " + firstUpdate);

        System.out.println("Second progress update: " + secondUpdate);

        System.out.println("Invalid progress update: " + invalidUpdate);

        System.out.println(
                "Progress: " + enrollment.calculateProgress() + "%");

        System.out.println(
                "Remaining lessons: " + enrollment.calculateRemainingLessons());

        System.out.println("Completed: " + enrollment.isCompleted());

        System.out.println("Active: " + enrollment.isActive());
    }
}
