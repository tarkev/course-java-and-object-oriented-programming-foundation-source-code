package module01.lesson09.example07;

public class Main {

    static final int MAXIMUM_STUDENT_CAPACITY = 100;

    public static void main(String[] args) {
        String courseName = "Java and OOP Foundation";
        int enrolledStudentCount = 75;
        boolean enrollmentOpen = true;

        enrolledStudentCount = 76;

        System.out.println("Course: " + courseName);
        System.out.println("Enrolled students: " + enrolledStudentCount);
        System.out.println("Maximum capacity: " + MAXIMUM_STUDENT_CAPACITY);
        System.out.println("Enrollment open: " + enrollmentOpen);
    }
}
