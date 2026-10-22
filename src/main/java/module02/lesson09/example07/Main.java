package module02.lesson09.example07;

public class Main {

    public static void main(String[] args) {
        show(3);
        System.out.println();
    }

    static void show(int number) {
        if (number == 0) {
            return;
        }
        show(number - 1);
        System.out.print(number + " ");
    }
}
