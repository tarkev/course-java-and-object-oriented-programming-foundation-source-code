package module09.lesson08.example13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) throws IOException {
        Path target = Path.of("course-info.md");
        replaceSafely(target, "Version 1");
        replaceSafely(target, "Version 2");
        System.out.println(Files.readString(target, StandardCharsets.UTF_8));
    }

    static void replaceSafely(Path target, String content) {
        if (target == null || content == null) {
            throw new IllegalArgumentException("Target and content are required.");
        }

        Path parent = target.toAbsolutePath().normalize().getParent();
        Path temp = null;

        try {
            Files.createDirectories(parent);
            temp = Files.createTempFile(parent, "write-", ".tmp");
            Files.writeString(temp, content, StandardCharsets.UTF_8);

            try {
                Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException exception) {
                Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not safely replace " + target + ".", exception);
        } finally {
            if (temp != null) {
                try {
                    Files.deleteIfExists(temp);
                } catch (IOException ignored) {
                    // A real application logs this cleanup failure.
                }
            }
        }
    }
}
