package module06.lesson11.example03;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        System.out.println(firstErrorIndex("{[()]}"));
        System.out.println(firstErrorIndex("{[(])}"));
        System.out.println(firstErrorIndex("list.get(0))"));
        System.out.println(firstErrorIndex("if (a[0] > 1) {"));
        System.out.println(firstErrorIndex(""));
    }

    static int firstErrorIndex(String text) {
        Deque<Integer> openIndexes = new ArrayDeque<>();

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);

            if (isOpening(current)) {
                openIndexes.push(index);
                continue;
            }

            if (isClosing(current)) {
                if (openIndexes.isEmpty()) {
                    return index;
                }

                char opening = text.charAt(openIndexes.pop());

                if (!matches(opening, current)) {
                    return index;
                }
            }
        }

        return openIndexes.isEmpty() ? -1 : openIndexes.peek();
    }

    static boolean isOpening(char value) {
        return value == '(' || value == '[' || value == '{';
    }

    static boolean isClosing(char value) {
        return value == ')' || value == ']' || value == '}';
    }

    static boolean matches(char opening, char closing) {
        return opening == '(' && closing == ')'
                || opening == '[' && closing == ']'
                || opening == '{' && closing == '}';
    }
}
