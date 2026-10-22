package module10.lesson04.example02.content;

import java.util.Arrays;
import java.util.Objects;

public record Attachment(String name, byte[] data) {

    public Attachment {
        Objects.requireNonNull(name, "Name is required.");
        data = Objects.requireNonNull(data, "Data is required.").clone();
    }

    @Override
    public byte[] data() {
        return data.clone();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Attachment attachment
                && name.equals(attachment.name)
                && Arrays.equals(data, attachment.data);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        return "Attachment[name=" + name + ", data=" + Arrays.toString(data) + "]";
    }
}
