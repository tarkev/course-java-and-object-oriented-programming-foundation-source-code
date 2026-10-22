// Generated from modules/06-algorithms-and-problem-solving-with-java/05-java-s-built-in-sorting-and-searching-apis.md by tools/extract_code.py. Edit the lesson, not this file.
package module06.lesson05.example01;

public final class Course implements Comparable<Course> {

    private final String code;
    private final String title;
    private final long priceInPaisa;

    public Course(String code, String title, long priceInPaisa) {
        this.code = code;

        this.title = title;

        this.priceInPaisa = priceInPaisa;
    }

    @Override
    public int compareTo(Course other) {
        return code.compareTo(other.code);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public long getPriceInPaisa() {
        return priceInPaisa;
    }
}
