package module05.lesson10.example08;

import java.util.ArrayList;
import java.util.List;

public class RemoveDemo {

    public static void main(String[] args) {
        List<Integer> copies = new ArrayList<>(List.of(0, 0, 3, 0));

        for (int index = 0; index < copies.size(); index++) {
            if (copies.get(index) == 0) {
                copies.remove(index);
            }
        }

        System.out.println(copies);
    }
}
