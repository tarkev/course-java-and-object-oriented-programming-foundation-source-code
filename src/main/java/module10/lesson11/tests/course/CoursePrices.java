package module10.lesson11.tests.course;

import java.util.List;

public final class CoursePrices {

    private CoursePrices() {
    }

    public static long totalPriceInPaisa(List<Course> courses) {
        long total = 0;
        for (int i = 0; i < courses.size(); i++) {
            total += courses.get(i).getPriceInPaisa();
        }
        return total;
    }
}
