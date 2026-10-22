package module05.lesson10.example02;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ShelfCode code = new ShelfCode("A-12");
        Map<ShelfCode, String> booksByShelf = new HashMap<>();
        booksByShelf.put(code, "Clean Code");

        code.change("B-07");

        System.out.println(booksByShelf.get(code));
        System.out.println(booksByShelf.size());
    }
}

class ShelfCode {

    private String value;

    ShelfCode(String value) {
        this.value = value;
    }

    void change(String newValue) {
        this.value = newValue;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ShelfCode code && value.equals(code.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
