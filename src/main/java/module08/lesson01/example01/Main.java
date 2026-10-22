// Generated from modules/08-enums-exceptions-and-robust-error-handling/01-enums-and-domain-states.md by tools/extract_code.py. Edit the lesson, not this file.
package module08.lesson01.example01;

import module08.lesson01.example01.course.Course;

public class Main {

    public static void main(
            String[] args
    ) {
        Course course =
                new Course(
                        1L,
                        "Java and OOP Foundation"
                );

        System.out.println(
                course.getStatus()
        );

        System.out.println(
                "Publish directly: "
                + course.publish()
        );

        System.out.println(
                "Submit for review: "
                + course.submitForReview()
        );

        System.out.println(
                "Publish: "
                + course.publish()
        );

        System.out.println(
                "Publicly visible: "
                + course.isPubliclyVisible()
        );

        System.out.println(
                "Archive: "
                + course.archive()
        );

        System.out.println(
                course.getStatus()
        );
    }
}
