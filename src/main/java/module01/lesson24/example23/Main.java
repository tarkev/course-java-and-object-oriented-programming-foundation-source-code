package module01.lesson24.example23;

public class Main {

    public static void main(String[] args) {
        String text = "Java Foundation";
        char target = 'a';
        int foundIndex = -1;
        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) == target) {
                foundIndex = index;
                break;
            }
        }
        System.out.println("First index of 'a': " + foundIndex);
    }
}
