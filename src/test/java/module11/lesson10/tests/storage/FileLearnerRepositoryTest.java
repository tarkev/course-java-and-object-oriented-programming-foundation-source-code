package module11.lesson10.tests.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import module11.lesson10.tests.learner.EmailAddress;
import module11.lesson10.tests.learner.Learner;
import module11.lesson10.tests.learner.LearnerId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

class FileLearnerRepositoryTest {

    private static final LearnerId SAKIB_ID = new LearnerId(1L);
    private static final Learner SAKIB = new Learner(
            SAKIB_ID, "Sakib", new EmailAddress("sakib@example.com"));

    @TempDir
    Path directory;

    @Test
    void savedLearnerSurvivesARestart() {
        new FileLearnerRepository(directory).save(SAKIB);

        Optional<Learner> loaded =
                new FileLearnerRepository(directory).findById(SAKIB_ID);

        assertEquals(Optional.of(SAKIB), loaded);
    }

    @Test
    void emailInAnotherCaseFindsTheStoredLearner() {
        new FileLearnerRepository(directory).save(SAKIB);

        Optional<Learner> found = new FileLearnerRepository(directory)
                .findByEmail(new EmailAddress("SAKIB@example.com"));

        assertEquals(Optional.of(SAKIB), found);
    }

    @Test
    void negativeIdIsCorruptedData() throws IOException {
        Files.writeString(directory.resolve("1.properties"),
                "id=-10\nname=Sakib\nemail=sakib@example.com\n");
        FileLearnerRepository repository = new FileLearnerRepository(directory);

        StoredDataCorruptionException exception = assertThrows(
                StoredDataCorruptionException.class,
                () -> repository.findById(SAKIB_ID));

        assertEquals("Invalid learner data in 1.properties.",
                exception.getMessage());
    }
}
