package Classes;

public enum MovieGenre {
    ACTION(0),
    FANTASY(1),
    SCIENCE_FICTION(2);

    private int code;

    private MovieGenre(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}