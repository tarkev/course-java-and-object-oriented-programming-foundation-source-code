package module10.lesson09.example06;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        int[] pixels = {255, 128, 0};
        Thumbnail first = new Thumbnail("logo", pixels);
        Thumbnail second = new Thumbnail("logo", new int[] {255, 128, 0});

        pixels[0] = 1;
        first.pixels()[1] = 1;

        System.out.println(first);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }
}

record Thumbnail(String name, int[] pixels) {

    Thumbnail {
        Objects.requireNonNull(name, "Name is required.");
        pixels = Objects.requireNonNull(pixels, "Pixels are required.").clone();
    }

    @Override
    public int[] pixels() {
        return pixels.clone();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Thumbnail thumbnail
                && name.equals(thumbnail.name)
                && Arrays.equals(pixels, thumbnail.pixels);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + Arrays.hashCode(pixels);
    }

    @Override
    public String toString() {
        return "Thumbnail[name=" + name + ", pixels=" + Arrays.toString(pixels) + "]";
    }
}
