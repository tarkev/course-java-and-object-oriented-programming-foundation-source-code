// Generated from modules/10-professional-java-practices/01-organizing-java-applications-with-packages.md by tools/extract_code.py. Edit the lesson, not this file.
package module10.lesson01.example01;

import module10.lesson01.example01.course.CourseCode;
import module10.lesson01.example01.course.CourseRepository;
import module10.lesson01.example01.course.CourseService;
import module10.lesson01.example01.course.storage.InMemoryCourseRepository;

public class Main {

    public static void main(
            String[] args
    ) {
        CourseRepository repository =
                new InMemoryCourseRepository();

        CourseService service =
                new CourseService(
                        repository
                );

        service.createCourse(
                new CourseCode(
                        "JAVA-OOP"
                ),
                "Java and OOP Foundation"
        );

        service.findAll()
                .forEach(
                        course ->
                                System.out.println(
                                        course.getTitle()
                                )
                );
    }
}
