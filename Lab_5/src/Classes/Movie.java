package Classes;

import java.time.LocalDate;

public class Movie {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private Long oscarsCount;
    private long goldenPalmCount;
    private MovieGenre genre;
    private MpaaRating mpaaRating;
    private Person operator;

    public void setId(long n){
        this.id = n;
    }

    public void setName(String s){
        this.name = s;
    }

    public void setCoordinates(Coordinates c){
        this.coordinates = c;
    }

    public void setCreationDate(LocalDate d){
        this.creationDate = d;
    }

    public void setOscarsCount(Long c){
        this.oscarsCount = c;
    }

    public void setGoldenPalmCount(Long c){
        this.goldenPalmCount = c;
    }

    public void setGenre(MovieGenre g){
        this.genre = g;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", goldenPalmCount=" + goldenPalmCount +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", operator=" + operator +
                '}';
    }

    public String toJson(){
        return "{" + "\n \t \t" +
                "\"id\":" + id + ",\n \t \t" +
                "\"name\":" + name + ",\n \t \t" +
                "\"coordinates\":" + coordinates + ",\n \t \t" +
                "\"creationDate\":" + creationDate + ",\n \t \t" +
                "\"oscarsCount\":" + oscarsCount + ",\n \t \t" +
                "\"goldenPalmCount\":" + goldenPalmCount + ",\n \t \t" +
                "\"genre\":" + genre + ",\n \t \t" +
                "\"mpaaRating\":" + mpaaRating + ",\n \t \t" +
                "\"operator\":" + operator + "\n \t \t" +
                "},";
    }
}