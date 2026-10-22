package module09.lesson08.example14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path source = Path.of("course-files", "images", "cover.png");
        Path first = Path.of("cover-copy.png");
        Path second = Path.of("cover-copy-2.png");
        copyImage(source, first);
        copyImageWithTransferTo(source, second);

        System.out.println("Source: " + Files.size(source) + " bytes");
        System.out.println("Buffer copy: " + Files.size(first) + " bytes");
        System.out.println("transferTo copy: " + Files.size(second) + " bytes");
    }

    static void copyImage(Path source, Path target) {
        try (InputStream input = Files.newInputStream(source);
                OutputStream output = Files.newOutputStream(target)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Could not copy image.", exception);
        }
    }

    static void copyImageWithTransferTo(Path source, Path target) {
        try (InputStream input = Files.newInputStream(source);
                OutputStream output = Files.newOutputStream(target)) {
            input.transferTo(output);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not copy image.", exception);
        }
    }
}
