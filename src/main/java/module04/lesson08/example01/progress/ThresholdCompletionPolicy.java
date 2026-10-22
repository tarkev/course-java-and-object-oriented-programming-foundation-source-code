// Generated from modules/04-inheritance-interfaces-and-polymorphism/08-project-polymorphic-content-system.md by tools/extract_code.py. Edit the lesson, not this file.
package module04.lesson08.example01.progress;

public final class ThresholdCompletionPolicy
        implements CompletionPolicy {

    private final int requiredPercentage;

    public ThresholdCompletionPolicy(int requiredPercentage) {
        if (requiredPercentage <= 0 || requiredPercentage > 100) {
            throw new IllegalArgumentException(
                    "Required percentage must be between 1 and 100.");
        }

        this.requiredPercentage = requiredPercentage;
    }

    @Override
    public boolean isCompleted(int progressPercentage) {
        return progressPercentage >= requiredPercentage;
    }

    @Override
    public String getDescription() {
        return "Requires at least " + requiredPercentage + "% progress";
    }
}
