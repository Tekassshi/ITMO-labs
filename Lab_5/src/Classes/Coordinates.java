package Classes;

public class Coordinates {
    private long x;
    private Double y;

    public String getCoordinates(){
        return ("{" + this.x + "" + ';' + this.y + "" + "}");
    }
    public String getX(){
        return this.x + "";
    }
    public String getY(){
        return this.y + "";
    }

    public void setCoordinates(long x, Double y){
        this.x = x;
        this.y = y;
    }
    public void setX(long x){
        this.x = x;
    }
    public void setY(Double y){
        this.y = y;
    }
}
