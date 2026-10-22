package module11.lesson02.example01;

import module11.lesson02.example01.course.Course;
import module11.lesson02.example01.course.CourseCode;
import module11.lesson02.example01.course.Lesson;
import module11.lesson02.example01.course.LessonId;
import module11.lesson02.example01.enrollment.Enrollment;
import module11.lesson02.example01.enrollment.EnrollmentId;
import module11.lesson02.example01.learner.EmailAddress;
import module11.lesson02.example01.learner.Learner;
import module11.lesson02.example01.learner.LearnerId;

public class DomainModelDemo {

    public static void main(String[] args) {
        Course course = new Course(
                new CourseCode("java-oop"), "Java and OOP Foundation", 499_000L);
        course.addLesson(new Lesson(new LessonId(1L),
                "Introduction to Java",
                "Java is a general-purpose programming language."));
        course.publish();
        System.out.println(course.summary());

        try {
            course.addLesson(new Lesson(new LessonId(2L),
                    "Variables", "Variables store values."));
        } catch (IllegalStateException exception) {
            System.out.println("Rejected: " + exception.getMessage());
        }

        Learner learner = new Learner(new LearnerId(1L), "Sakib",
                new EmailAddress("Sakib@Example.com"));

        Enrollment enrollment = new Enrollment(
                new EnrollmentId(1001L), learner.id(), course.getCode());
        enrollment.complete();
        System.out.println(enrollment.summary());

        try {
            enrollment.cancel();
        } catch (IllegalStateException exception) {
            System.out.println("Rejected: " + exception.getMessage());
        }

        course.archive();
        System.out.println("Course status: " + course.getStatus());
    }
}
