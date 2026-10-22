package module02.lesson11.example17;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse("Java"));
        System.out.println(reverse("Nur"));
        System.out.println("[" + reverse("") + "]");
    }

    static String reverse(String text) {
        if (text.length() == 0) {
            return text;
        }
        return reverse(text.substring(1)) + text.charAt(0);
    }
}
