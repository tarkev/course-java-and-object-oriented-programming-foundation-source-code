package module01.lesson11.example01;

public class Main {

    public static void main(String[] args) {
        String rawCourseName = "   Java and OOP Foundation   ";
        String courseName = rawCourseName.strip();

        System.out.println("Course: " + courseName);
        System.out.println("Length: " + courseName.length());
        System.out.println(
                "Starts with Java: " + courseName.startsWith("Java"));
        System.out.println("Contains OOP: " + courseName.contains("OOP"));
        System.out.println("Uppercase: " + courseName.toUpperCase());
    }
}
