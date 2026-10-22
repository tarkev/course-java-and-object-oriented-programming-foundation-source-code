package module11.lesson06.example01.console;

import module11.lesson06.example01.course.CourseCode;
import module11.lesson06.example01.course.CourseService;
import module11.lesson06.example01.course.CourseSummary;
import module11.lesson06.example01.course.Lesson;
import module11.lesson06.example01.course.LessonId;
import module11.lesson06.example01.enrollment.EnrollmentId;
import module11.lesson06.example01.enrollment.EnrollmentService;
import module11.lesson06.example01.enrollment.EnrollmentSummary;
import module11.lesson06.example01.learner.EmailAddress;
import module11.lesson06.example01.learner.Learner;
import module11.lesson06.example01.learner.LearnerId;
import module11.lesson06.example01.learner.LearnerService;

import java.util.List;
import java.util.Scanner;

public final class ConsoleApplication {

    private final CourseService courseService;
    private final LearnerService learnerService;
    private final EnrollmentService enrollmentService;
    private final Scanner scanner;

    public ConsoleApplication(
            CourseService courseService,
            LearnerService learnerService,
            EnrollmentService enrollmentService,
            Scanner scanner) {
        if (courseService == null || learnerService == null
                || enrollmentService == null || scanner == null) {
            throw new IllegalArgumentException(
                    "Console dependencies are required.");
        }
        this.courseService = courseService;
        this.learnerService = learnerService;
        this.enrollmentService = enrollmentService;
        this.scanner = scanner;
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = readLine("Choose option: ").strip();

            try {
                switch (choice) {
                    case "1" -> createCourse();
                    case "2" -> addLesson();
                    case "3" -> publishCourse();
                    case "4" -> archiveCourse();
                    case "5" -> listCourses();
                    case "6" -> registerLearner();
                    case "7" -> listLearners();
                    case "8" -> enrollLearner();
                    case "9" -> completeEnrollment();
                    case "10" -> cancelEnrollment();
                    case "11" -> listEnrollments();
                    case "0" -> running = false;
                    default -> System.out.println("Unknown option: " + choice);
                }
            } catch (RuntimeException exception) {
                System.out.println("Error: " + exception.getMessage());
            }

            System.out.println();
        }

        System.out.println("Goodbye.");
    }

    private void printMenu() {
        System.out.println("=== Tarkev Course Enrollment System ===");
        System.out.println("1. Create course");
        System.out.println("2. Add lesson");
        System.out.println("3. Publish course");
        System.out.println("4. Archive course");
        System.out.println("5. List courses");
        System.out.println("6. Register learner");
        System.out.println("7. List learners");
        System.out.println("8. Enroll learner");
        System.out.println("9. Complete enrollment");
        System.out.println("10. Cancel enrollment");
        System.out.println("11. List enrollments");
        System.out.println("0. Exit");
    }

    private void createCourse() {
        CourseCode code = readCourseCode();
        String title = readLine("Title: ");
        long price = readLong("Price in paisa: ");

        courseService.createCourse(code, title, price);
        System.out.println("Course created successfully.");
    }

    private void addLesson() {
        CourseCode courseCode = readCourseCode();
        LessonId lessonId = new LessonId(readLong("Lesson id: "));
        String title = readLine("Lesson title: ");
        String content = readLine("Lesson content: ");

        courseService.addLesson(
                courseCode, new Lesson(lessonId, title, content));
        System.out.println("Lesson added successfully.");
    }

    private void publishCourse() {
        CourseCode courseCode = readCourseCode();

        courseService.publishCourse(courseCode);
        System.out.println("Course published successfully.");
    }

    private void archiveCourse() {
        CourseCode courseCode = readCourseCode();

        courseService.archiveCourse(courseCode);
        System.out.println("Course archived successfully.");
    }

    private void listCourses() {
        List<CourseSummary> courses = courseService.findAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        for (CourseSummary course : courses) {
            System.out.printf("%s | %s | %d | %s | lessons=%d%n",
                    course.code(), course.title(), course.priceInPaisa(),
                    course.status(), course.lessonCount());
        }
    }

    private void registerLearner() {
        LearnerId learnerId = new LearnerId(readLong("Learner id: "));
        String name = readLine("Name: ");
        EmailAddress email = new EmailAddress(readLine("Email: "));

        learnerService.registerLearner(learnerId, name, email);
        System.out.println("Learner registered successfully.");
    }

    private void listLearners() {
        List<Learner> learners = learnerService.findAllLearners();

        if (learners.isEmpty()) {
            System.out.println("No learners found.");
            return;
        }

        for (Learner learner : learners) {
            System.out.printf("%s | %s | %s%n",
                    learner.id(), learner.name(), learner.email());
        }
    }

    private void enrollLearner() {
        EnrollmentId enrollmentId = readEnrollmentId();
        LearnerId learnerId = new LearnerId(readLong("Learner id: "));
        CourseCode courseCode = readCourseCode();

        enrollmentService.enroll(enrollmentId, learnerId, courseCode);
        System.out.println("Enrollment created successfully.");
    }

    private void completeEnrollment() {
        EnrollmentId enrollmentId = readEnrollmentId();

        enrollmentService.completeEnrollment(enrollmentId);
        System.out.println("Enrollment completed successfully.");
    }

    private void cancelEnrollment() {
        EnrollmentId enrollmentId = readEnrollmentId();

        enrollmentService.cancelEnrollment(enrollmentId);
        System.out.println("Enrollment cancelled successfully.");
    }

    private void listEnrollments() {
        List<EnrollmentSummary> enrollments =
                enrollmentService.findAllEnrollments();

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        for (EnrollmentSummary enrollment : enrollments) {
            System.out.printf("%s | learner=%s | course=%s | %s%n",
                    enrollment.id(), enrollment.learnerId(),
                    enrollment.courseCode(), enrollment.status());
        }
    }

    private CourseCode readCourseCode() {
        return new CourseCode(readLine("Course code: "));
    }

    private EnrollmentId readEnrollmentId() {
        return new EnrollmentId(readLong("Enrollment id: "));
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private long readLong(String prompt) {
        String value = readLine(prompt);

        try {
            return Long.parseLong(value.strip());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Expected a whole number but got: " + value);
        }
    }
}
