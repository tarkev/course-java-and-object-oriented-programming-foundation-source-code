package module02.lesson10.example11;

public class Main {

    public static void main(String[] args) {
        printMessage("Welcome to Tarkev");
        printMessage("Keep practising", 3);
    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    static void printMessage(String message, int times) {
        for (int count = 1; count <= times; count++) {
            System.out.println(message);
        }
    }
}
