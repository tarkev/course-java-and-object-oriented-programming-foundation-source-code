package module10.lesson09.example01.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CourseCatalog {

    private final List<String> codes = new ArrayList<>();

    public void add(String code) {
        String normalized = code.strip().toUpperCase(Locale.ROOT);

        for (String existing : codes) {
            if (existing.equalsIgnoreCase(code)) {
                throw new IllegalArgumentException(
                        "Course already exists: " + normalized + ".");
            }
        }

        codes.add(normalized);
    }

    public int size() {
        return codes.size();
    }
}
