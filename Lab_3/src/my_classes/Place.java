package my_classes;

import java.util.Objects;

public abstract class Place {
    protected String name;
    public abstract void show_name();

    public void from() {
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

        Place place = (Place) obj;

        return (place.name == this.name);
    }

    @Override
    public int hashCode(){
        return (Objects.hashCode(name));
    }

    @Override
    public String toString(){
        return "'" + name + "'";
    }
}