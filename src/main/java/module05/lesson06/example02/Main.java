// Generated from modules/05-generics-collections-and-core-data-structures/06-deque-stack-and-arraydeque.md by tools/extract_code.py. Edit the lesson, not this file.
package module05.lesson06.example02;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        stack.push("Java");

        stack.push("Backend");

        stack.push("System Design");

        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }
}
