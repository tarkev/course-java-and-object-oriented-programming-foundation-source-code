package module09.lesson05.example01;

public final class DemoResource implements AutoCloseable {

    private final String name;

    public DemoResource(String name) {
        this.name = name;
        System.out.println("Open " + name);
    }

    @Override
    public void close() {
        System.out.println("Close " + name);
    }
}
