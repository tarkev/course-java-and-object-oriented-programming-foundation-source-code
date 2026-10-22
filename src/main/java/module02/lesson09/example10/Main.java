package module02.lesson09.example10;

public class Main {

    public static void main(String[] args) {
        System.out.println(classifyScore(95));
        System.out.println(classifyScore(90));
        System.out.println(classifyScore(75));
        System.out.println(classifyScore(40));
        System.out.println(classifyScore(-5));
        System.out.println(classifyScore(101));
    }

    static String classifyScore(int score) {
        if (score < 0 || score > 100) {
            return "Invalid";
        }
        if (score >= 90) {
            return "Excellent";
        }
        if (score >= 70) {
            return "Good";
        }
        return "Needs Improvement";
    }
}
