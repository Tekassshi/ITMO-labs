package my_classes;

public class Subject {
    protected String name;

    public void show_name() {
        System.out.print(name);
    }

    public Subject(String name) {
        this.name = name;
    }
}
