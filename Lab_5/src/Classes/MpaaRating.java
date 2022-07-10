package Classes;

public enum MpaaRating {
    G(0),
    PG(1),
    PG_13(2),
    NC_17(3);

    private int code;

    private MpaaRating(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}