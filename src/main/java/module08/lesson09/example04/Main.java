package module08.lesson09.example04;

public class Main {

    public static void main(String[] args) {
        for (CourseStatus from : CourseStatus.values()) {
            for (CourseStatus to : CourseStatus.values()) {
                if (from.canTransitionTo(to)) {
                    System.out.println(from + " → " + to);
                }
            }
        }

        System.out.println("DRAFT → PUBLISHED: "
                + CourseStatus.DRAFT.canTransitionTo(CourseStatus.PUBLISHED));
        System.out.println("DRAFT → null: "
                + CourseStatus.DRAFT.canTransitionTo(null));
    }
}

enum CourseStatus {

    DRAFT, REVIEW, PUBLISHED, ARCHIVED;

    public boolean canTransitionTo(CourseStatus target) {
        if (target == null) {
            return false;
        }

        return switch (this) {
            case DRAFT -> target == REVIEW;
            case REVIEW -> target == DRAFT || target == PUBLISHED;
            case PUBLISHED -> target == ARCHIVED;
            case ARCHIVED -> false;
        };
    }
}
