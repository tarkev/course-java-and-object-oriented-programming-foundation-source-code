package module09.lesson08.example01;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        System.out.println(buildCoursePath(Path.of("content"), "java-oop"));
    }

    static Path buildCoursePath(Path baseDirectory, String courseCode) {
        if (baseDirectory == null) {
            throw new IllegalArgumentException("Base directory is required.");
        }

        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException("Course code is required.");
        }

        return baseDirectory.resolve(courseCode.strip());
    }
}
