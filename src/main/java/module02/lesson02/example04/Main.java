package module02.lesson02.example04;

public class Main {

    public static void main(String[] args) {
        System.out.println(grade(90));
        System.out.println(grade(40));
    }

    static String grade(int score) {
        if (score >= 50) {
            return "Pass";
        }
        if (score >= 80) {
            return "Excellent";
        }
        return "Fail";
    }
}
