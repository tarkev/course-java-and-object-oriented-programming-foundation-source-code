package module10.lesson09.example01;

import module10.lesson09.example01.course.CourseCatalog;

public class Main {

    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();
        catalog.add("JAVA-OOP");
        catalog.add("BACKEND");
        catalog.add(" java-oop ");

        System.out.println("Courses in catalog: " + catalog.size());
    }
}
