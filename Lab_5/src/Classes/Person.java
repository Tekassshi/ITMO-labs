package Classes;

/** Класс, предназначенный для поля operator объекта класса Movie
 * @see Movie
 * */
public class Person {

    /** Имя объекта*/
    private String name;

    /** Рост объекта*/
    private double height;

    /** Цвет глаз объекта*/
    private Color eyeColor;

    /** Цвет волос объекта*/
    private Color hairColor;

    /** Метод возвращает значение поля name
     * @return String
     * @see String
     * */
    public String getName(){
        return this.name;
    }

    /** Установить значение поля name
     * @param name имя объекта класса String
     * @see String
     * */
    public void setName(String name){
         this.name = name;
    }

    /** Метод возвращает значение поля height
     * @return double
     * */
    public double getHeight() {
        return height;
    }

    /** Установить значение поля height
     * @param height имя объекта типа double
     * */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Метод возвращает значение поля eyeColor
     * @return Color
     * @see Color
     * */
    public Color getEyeColor() {
        return eyeColor;
    }

    /** Установить значение поля eyeColor
     * @param eyeColor цвет глаз объекта класса Color
     * @see Color
     * */
    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    /** Метод возвращает значение поля hairColor
     * @return Color
     * @see Color
     * */
    public Color getHairColor() {
        return hairColor;
    }

    /** Установить значение поля hairColor
     * @param hairColor цвет волос объекта класса Color
     * @see Color
     * */
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

}