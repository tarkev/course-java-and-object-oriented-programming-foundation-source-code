package module06.lesson10.example06;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome("LEVEL"));
        System.out.println(isPalindrome("JAVA"));
    }

    static boolean isPalindrome(String value) {
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
