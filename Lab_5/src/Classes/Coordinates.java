package Classes;

/** Класс, объекты которого хранят координаты "x" и "y"*/

public class Coordinates {
    private long x;
    private Double y;


    /** Метод, возвращающий значения координат в строковом виде
     * @return String
     * */
    public String getCoordinates(){
        return ("{" + this.x + "" + ';' + this.y + "" + "}");
    }

    /** Метод, возвращающий значение координаты "x" в строковом виде
     * @return String
     * */
    public String getX(){
        return this.x + "";
    }

    /** Метод, возвращающий значение координаты "y" в строковом виде
     * @return String
     * */
    public String getY(){
        return this.y + "";
    }

    /** Метод, устанавливающий значения координат "x" и "y" */
    public void setCoordinates(long x, Double y){
        this.x = x;
        this.y = y;
    }

    /** Метод, устанавливающий значение координаты "x" */
    public void setX(long x){
        this.x = x;
    }

    /** Метод, устанавливающий значение координаты "y" */
    public void setY(Double y){
        this.y = y;
    }
}
