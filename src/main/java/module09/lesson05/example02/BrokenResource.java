package module09.lesson05.example02;

import java.io.IOException;

public final class BrokenResource implements AutoCloseable {

    @Override
    public void close() throws IOException {
        throw new IOException("Close failed");
    }
}
