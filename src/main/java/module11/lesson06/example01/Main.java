package module11.lesson06.example01;

import module11.lesson06.example01.console.ConsoleApplication;
import module11.lesson06.example01.course.CourseRepository;
import module11.lesson06.example01.course.CourseService;
import module11.lesson06.example01.enrollment.EnrollmentRepository;
import module11.lesson06.example01.enrollment.EnrollmentService;
import module11.lesson06.example01.learner.LearnerRepository;
import module11.lesson06.example01.learner.LearnerService;
import module11.lesson06.example01.storage.FileCourseRepository;
import module11.lesson06.example01.storage.FileEnrollmentRepository;
import module11.lesson06.example01.storage.FileLearnerRepository;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Path dataDirectory = Path.of("data");

        CourseRepository courseRepository =
                new FileCourseRepository(dataDirectory.resolve("courses"));
        LearnerRepository learnerRepository =
                new FileLearnerRepository(dataDirectory.resolve("learners"));
        EnrollmentRepository enrollmentRepository =
                new FileEnrollmentRepository(
                        dataDirectory.resolve("enrollments"));

        CourseService courseService = new CourseService(courseRepository);
        LearnerService learnerService =
                new LearnerService(learnerRepository);
        EnrollmentService enrollmentService = new EnrollmentService(
                courseRepository, learnerRepository, enrollmentRepository);

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleApplication application = new ConsoleApplication(
                    courseService, learnerService, enrollmentService, scanner);
            application.run();
        }
    }
}
