// Generated from modules/06-algorithms-and-problem-solving-with-java/06-using-stacks-queues-and-deques-in-algorithms.md by tools/extract_code.py. Edit the lesson, not this file.
package module06.lesson06.example01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));

        System.out.println(isBalanced("{[(])}"));
    }

    static boolean isBalanced(String value) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < value.length(); index++) {
            char current = value.charAt(index);

            if (isOpening(current)) {
                stack.push(current);

                continue;
            }

            if (isClosing(current)) {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if (!matches(opening, current)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
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
