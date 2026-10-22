package module02.lesson10.example14;

public class Main {

    public static void main(String[] args) {
        String[] courses = {"Java", "Python", "Go"};
        courses[1] = "Backend Development";
        for (int index = 0; index < courses.length; index++) {
            System.out.println(courses[index]);
        }
    }
}
