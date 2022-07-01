package Classes;

public class Person {
    private String name;
    private double height;
    private Color eyeColor;
    private Color hairColor;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
         this.name = name;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }
    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

}
