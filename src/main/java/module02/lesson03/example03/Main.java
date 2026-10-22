package module02.lesson03.example03;

public class Main {

    static final int PASSING_MARK = 40;

    public static void main(String[] args) {
        printResult("Subu", 85);
        printResult(35);
    }

    static void printResult(String name, int mark) {
        String result = getResult(mark);
        System.out.println(name + ": " + result);
    }

    static void printResult(int mark) {
        printResult("Learner", mark);
    }

    static String getResult(int mark) {
        if (mark >= PASSING_MARK) {
            return "Passed";
        }

        return "Failed";
    }
}
