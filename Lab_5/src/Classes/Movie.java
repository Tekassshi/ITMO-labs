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
    public Long getId(){
        return this.id;
    }

    public void setName(String s){
        this.name = s;
    }
    public String getName(){
        return this.name;
    }

    public void setCoordinates(Coordinates c){
        this.coordinates = c;
    }
    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    public void setCreationDate(){
        this.creationDate = LocalDate.now();
    }
    public LocalDate getCreationDate(){
        return this.creationDate;
    }

    public void setOscarsCount(Long c){
        this.oscarsCount = c;
    }
    public Long getOscarsCount(){
        return this.oscarsCount;
    }

    public void setGoldenPalmCount(Long c){
        this.goldenPalmCount = c;
    }
    public long getGoldenPalmCount(){
        return this.goldenPalmCount;
    }

    public void setGenre(MovieGenre g){
        this.genre = g;
    }
    public MovieGenre getGenre(){
        return this.genre;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    public MpaaRating getMpaaRating() {
       return this.mpaaRating;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }
    public Person getOperator() {
        return this.operator;
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
}