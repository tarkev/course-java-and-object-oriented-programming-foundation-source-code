// Generated from modules/04-inheritance-interfaces-and-polymorphism/08-project-polymorphic-content-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson08.example01.content;

public interface Gradable {

    int calculateScore(int correctAnswers);

    boolean hasPassed(int correctAnswers);
}
