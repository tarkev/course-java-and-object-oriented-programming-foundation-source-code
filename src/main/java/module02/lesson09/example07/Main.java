package module02.lesson09.example07;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculateArea(5, 4));
        System.out.println(calculateArea(10, 3));
    }

    static int calculateArea(int width, int height) {
        return width * height;
    }
}
