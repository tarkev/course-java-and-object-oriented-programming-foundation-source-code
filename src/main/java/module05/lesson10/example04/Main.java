package module05.lesson10.example04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List titles = new ArrayList();
        titles.add("Clean Code");
        titles.add(42);

        for (Object title : titles) {
            String text = (String) title;
            System.out.println(text.toUpperCase());
        }
    }
}
