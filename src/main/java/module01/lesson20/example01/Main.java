// Generated from modules/01-programming-and-java-fundamentals/20-project-build-a-console-based-grade-calculator.md by tools/extract_code.py. Edit the lesson, not this file.
package module01.lesson20.example01;

import java.util.Scanner;

public class Main {

    static final int CALCULATE_RESULT_OPTION = 1;
    static final int VIEW_RULES_OPTION = 2;
    static final int EXIT_OPTION = 3;

    static final int MINIMUM_SUBJECT_COUNT = 1;
    static final int MAXIMUM_SUBJECT_COUNT = 10;

    static final int MINIMUM_MARK = 0;
    static final int MAXIMUM_MARK = 100;
    static final int PASSING_MARK = 40;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int menuOption;

        do {
            System.out.println();
            System.out.println("=== Grade Calculator ===");
            System.out.println();

            System.out.println("1. Calculate student result");

            System.out.println("2. View grade rules");

            System.out.println("3. Exit");

            System.out.println();

            System.out.print("Choose an option: ");

            menuOption = Integer.parseInt(scanner.nextLine().strip());

            switch (menuOption) {
                case CALCULATE_RESULT_OPTION -> {
                    System.out.println();
                    System.out.println("--- Student Information ---");

                    String studentName;

                    while (true) {
                        System.out.print("Enter student name: ");

                        studentName = scanner.nextLine().strip();

                        if (studentName.isBlank()) {
                            System.out.println("Student name is required.");

                            continue;
                        }

                        break;
                    }

                    int subjectCount;

                    while (true) {
                        System.out.print(
                                "Enter number of subjects ("
                                + MINIMUM_SUBJECT_COUNT + "-" + MAXIMUM_SUBJECT_COUNT + "): ");

                        subjectCount = Integer.parseInt(scanner.nextLine().strip());

                        if (subjectCount < MINIMUM_SUBJECT_COUNT
                                || subjectCount > MAXIMUM_SUBJECT_COUNT) {
                            System.out.println(
                                    "Subject count must be between "
                                    + MINIMUM_SUBJECT_COUNT + " and " + MAXIMUM_SUBJECT_COUNT + ".");

                            continue;
                        }

                        break;
                    }

                    int totalMarks = 0;

                    int highestMark = MINIMUM_MARK;

                    int lowestMark = MAXIMUM_MARK;

                    int passedSubjectCount = 0;
                    int failedSubjectCount = 0;

                    System.out.println();
                    System.out.println("--- Enter Subject Marks ---");

                    for (int subjectNumber = 1;
                            subjectNumber <= subjectCount;
                            subjectNumber++
                    ) {
                        int mark;

                        while (true) {
                            System.out.print(
                                    "Enter mark for subject "
                                    + subjectNumber + " (" + MINIMUM_MARK + "-" + MAXIMUM_MARK + "): ");

                            mark = Integer.parseInt(scanner.nextLine().strip());

                            if (mark < MINIMUM_MARK || mark > MAXIMUM_MARK) {
                                System.out.println(
                                        "Mark must be between "
                                        + MINIMUM_MARK + " and " + MAXIMUM_MARK + ".");

                                continue;
                            }

                            break;
                        }

                        totalMarks += mark;

                        if (mark > highestMark) {
                            highestMark = mark;
                        }

                        if (mark < lowestMark) {
                            lowestMark = mark;
                        }

                        if (mark >= PASSING_MARK) {
                            passedSubjectCount++;
                        } else {
                            failedSubjectCount++;
                        }
                    }

                    double averageMark = totalMarks / (double) subjectCount;

                    boolean passedAllSubjects = failedSubjectCount == 0;

                    String finalResult;

                    if (passedAllSubjects) {
                        finalResult = "Passed";
                    } else {
                        finalResult = "Failed";
                    }

                    String grade;

                    if (!passedAllSubjects) {
                        grade = "F";
                    } else if (averageMark >= 80) {
                        grade = "A";
                    } else if (averageMark >= 70) {
                        grade = "B";
                    } else if (averageMark >= 60) {
                        grade = "C";
                    } else if (averageMark >= 50) {
                        grade = "D";
                    } else {
                        grade = "E";
                    }

                    String performanceMessage = switch (grade) {
                        case "A" -> "Excellent performance";

                        case "B" -> "Very good performance";

                        case "C" -> "Good performance";

                        case "D" -> "Satisfactory performance";

                        case "E" -> "Passed, but improvement is needed";

                        case "F" -> "One or more subjects were failed";

                        default -> "Result unavailable";
                    };

                    int maximumPossibleMarks = subjectCount * MAXIMUM_MARK;

                    System.out.println();
                    System.out.println("=== Student Result ===");

                    System.out.println("Student: " + studentName);

                    System.out.println("Subjects: " + subjectCount);

                    System.out.println(
                            "Total marks: " + totalMarks + " out of " + maximumPossibleMarks);

                    System.out.println("Average mark: " + averageMark);

                    System.out.println("Highest mark: " + highestMark);

                    System.out.println("Lowest mark: " + lowestMark);

                    System.out.println("Passed subjects: " + passedSubjectCount);

                    System.out.println("Failed subjects: " + failedSubjectCount);

                    System.out.println("Grade: " + grade);

                    System.out.println("Result: " + finalResult);

                    System.out.println("Performance: " + performanceMessage);
                }

                case VIEW_RULES_OPTION -> {
                    String gradeRules = """
                            === Grade Rules ===

                            Passing mark per subject: 40

                            Average 80-100 → Grade A
                            Average 70-79  → Grade B
                            Average 60-69  → Grade C
                            Average 50-59  → Grade D
                            Average 40-49  → Grade E

                            If any subject mark is below 40:
                            Grade F and final result Failed
                            """;

                    System.out.println();
                    System.out.println(gradeRules);
                }

                case EXIT_OPTION -> System.out.println("Grade calculator closed.");

                default -> System.out.println("Invalid option. Choose 1, 2, or 3.");
            }

        } while (menuOption != EXIT_OPTION);

        scanner.close();
    }
}
