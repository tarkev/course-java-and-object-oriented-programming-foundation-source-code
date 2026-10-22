package module05.lesson07.example01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CourseOperations {

    private CourseOperations() {
    }

    public static List<Course> findPublishedCourses(
            List<Course> courses) {
        if (courses == null) {
            return List.of();
        }

        List<Course> result = new ArrayList<>();

        for (Course course : courses) {
            if (course != null && course.isPublished()) {
                result.add(course);
            }
        }

        return List.copyOf(result);
    }

    public static List<String> extractTitles(List<Course> courses) {
        if (courses == null) {
            return List.of();
        }

        List<String> titles = new ArrayList<>();

        for (Course course : courses) {
            if (course == null) {
                continue;
            }
            titles.add(course.getTitle());
        }

        return List.copyOf(titles);
    }

    public static long calculateTotalPrice(List<Course> courses) {
        long total = 0L;

        if (courses == null) {
            return total;
        }

        for (Course course : courses) {
            if (course == null) {
                continue;
            }
            total += course.getPriceInPaisa();
        }

        return total;
    }

    public static Course findMostExpensive(List<Course> courses) {
        if (courses == null) {
            return null;
        }

        Course mostExpensive = null;

        for (Course course : courses) {
            if (course == null) {
                continue;
            }
            if (mostExpensive == null
                    || course.getPriceInPaisa() > mostExpensive.getPriceInPaisa()) {
                mostExpensive = course;
            }
        }

        return mostExpensive;
    }

    public static Map<String, Integer> countByDifficulty(
            List<Course> courses) {
        if (courses == null) {
            return Map.of();
        }

        Map<String, Integer> counts = new HashMap<>();

        for (Course course : courses) {
            if (course == null) {
                continue;
            }
            String difficulty = course.getDifficulty();
            int currentCount = counts.getOrDefault(difficulty, 0);
            counts.put(difficulty, currentCount + 1);
        }

        return Map.copyOf(counts);
    }
}
