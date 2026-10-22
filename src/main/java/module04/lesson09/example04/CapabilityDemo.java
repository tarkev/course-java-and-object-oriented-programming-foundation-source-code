package module04.lesson09.example04;

interface Printable {

    String print();
}

interface Shareable {

    String share();
}

class Note implements Printable, Shareable {

    @Override
    public String print() {
        return "note";
    }

    @Override
    public String share() {
        return "link";
    }
}

class Poster implements Printable {

    @Override
    public String print() {
        return "poster";
    }
}

public class CapabilityDemo {

    public static void main(String[] args) {
        Printable[] items = {new Note(), new Poster()};

        for (Printable item : items) {
            String line = item.print();

            if (item instanceof Shareable shareable) {
                line = line + " + " + shareable.share();
            }

            System.out.println(line);
        }
    }
}
