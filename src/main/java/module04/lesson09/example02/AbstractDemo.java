package module04.lesson09.example02;

abstract class Resource {

    Resource() {
        System.out.println("Resource ready");
    }

    abstract String type();
}

class Handout extends Resource {

    Handout() {
        super();
        System.out.println("Handout ready");
    }

    @Override
    String type() {
        return "HANDOUT";
    }
}

public class AbstractDemo {

    public static void main(String[] args) {
        Resource resource = new Handout();
        System.out.println(resource.type());
    }
}
