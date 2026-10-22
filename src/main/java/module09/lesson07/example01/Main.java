// Generated from modules/09-file-handling-and-i-o/07-designing-a-file-based-repository.md by tools/extract_code.py. Edit the lesson, not this file.
package module09.lesson07.example01;

import module09.lesson07.example01.course.Course;
import module09.lesson07.example01.course.CourseCode;
import module09.lesson07.example01.course.CourseStatus;
import module09.lesson07.example01.repository.CourseRepository;
import module09.lesson07.example01.repository.FileCourseRepository;

import java.nio.file.Path;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseRepository repository =
                new FileCourseRepository(
                        Path.of(
                                "data",
                                "courses"
                        )
                );

        Course course =
                new Course(
                        new CourseCode(
                                "JAVA-OOP"
                        ),
                        "Java and OOP Foundation",
                        499_000L
                );

        course.changeStatus(
                CourseStatus.REVIEW
        );

        repository.save(
                course
        );

        Course loaded =
                repository.findByCode(
                        new CourseCode(
                                "java-oop"
                        )
                );

        System.out.println(
                loaded
        );

        repository.findAll()
                .forEach(
                        System.out::println
                );
    }
}
