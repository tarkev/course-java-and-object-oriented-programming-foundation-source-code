package module01.lesson24.example08;

public class Main {

    public static void main(String[] args) {
        String text = "Java Foundation";
        int count = 0;
        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);
            if (character == 'a' || character == 'A') {
                count++;
            }
        }
        System.out.println("Count: " + count);
    }
}
