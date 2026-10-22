package module01.lesson24.example17;

public class Main {

    public static void main(String[] args) {
        int mark = 73;

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark");
        } else if (mark >= 80) {
            System.out.println("Grade: A");
        } else if (mark >= 70) {
            System.out.println("Grade: B");
        } else if (mark >= 60) {
            System.out.println("Grade: C");
        } else if (mark >= 50) {
            System.out.println("Grade: D");
        } else if (mark >= 40) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: F");
        }
    }
}
