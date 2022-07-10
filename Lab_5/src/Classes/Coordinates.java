package Classes;

/** �����, ������� �������� ������ ���������� "x" � "y"*/

public class Coordinates {
    private long x;
    private Double y;


    /** �����, ������������ �������� ��������� � ��������� ����
     * @return String
     * */
    public String getCoordinates(){
        return ("{" + this.x + "" + ';' + this.y + "" + "}");
    }

    /** �����, ������������ �������� ���������� "x" � ��������� ����
     * @return String
     * */
    public String getX(){
        return this.x + "";
    }

    /** �����, ������������ �������� ���������� "y" � ��������� ����
     * @return String
     * */
    public String getY(){
        return this.y + "";
    }

    /** �����, ��������������� �������� ��������� "x" � "y" */
    public void setCoordinates(long x, Double y){
        this.x = x;
        this.y = y;
    }

    /** �����, ��������������� �������� ���������� "x" */
    public void setX(long x){
        this.x = x;
    }

    /** �����, ��������������� �������� ���������� "y" */
    public void setY(Double y){
        this.y = y;
    }
}
