package module10.lesson02.example01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyVsView {

    public static void main(String[] args) {
        List<String> lessons = new ArrayList<>(List.of("Variables"));

        List<String> mutableCopy = new ArrayList<>(lessons);
        List<String> snapshot = List.copyOf(lessons);
        List<String> view = Collections.unmodifiableList(lessons);

        lessons.add("Loops");

        System.out.println("mutable copy: " + mutableCopy);
        System.out.println("snapshot:     " + snapshot);
        System.out.println("view:         " + view);

        try {
            view.add("Arrays");
        } catch (UnsupportedOperationException exception) {
            System.out.println("view.add() is not allowed");
        }

        System.out.println(List.copyOf(snapshot) == snapshot);
        System.out.println(List.copyOf(view) == view);
    }
}
