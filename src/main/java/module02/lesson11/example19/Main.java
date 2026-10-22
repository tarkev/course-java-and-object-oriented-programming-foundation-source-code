package module02.lesson11.example19;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("java"));
        System.out.println(isPalindrome(""));
    }

    static boolean isPalindrome(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindrome(text.substring(1, text.length() - 1));
    }
}
