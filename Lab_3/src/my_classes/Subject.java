package my_classes;

import java.util.Objects;

public class Subject {
    protected String name;

    public void show_name() {
        System.out.print(name);
    }

    public Subject(String name) {
        this.name = name;
    }

    // переопределение базовых методов
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Subject subject = (Subject) obj;

        return (this.name == subject.name);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }

    @Override
    public String toString(){
        return "'" + name + "'";
    }
}
