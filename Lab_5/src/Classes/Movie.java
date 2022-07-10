package Classes;

import java.time.LocalDateTime;

/** Класс, являющийся элементом коллекции
 * @see Person
 * @see Coordinates
 * @see Color
 * @see MovieGenre
 * @see MpaaRating
 * */

public class Movie implements Comparable{

    /** id объекта*/
    private Long id;

    /** Имя объекта*/
    private String name;

    /** Координаты объекта
     * @see Coordinates
     * */
    private Coordinates coordinates;

    /** Дата и время создания объекта
     * @see LocalDateTime
     * */
    private LocalDateTime creationDate;

    /** Количество оскаров */
    private Long oscarsCount;

    /** Количество золотых пальм */
    private long goldenPalmCount;

    /** Жанр фильма
     * @see MovieGenre
     * */
    private MovieGenre genre;

    /** Рейтинг Mpaa
     * @see MpaaRating
     * */
    private MpaaRating mpaaRating;

    /** Оператор
     * @see Person
     * */
    private Person operator;

    /** Установить значение id */
    public void setId(long n){
        this.id = n;
    }

    /** Получить значение id
     * @see Movie#setId(long)
     * @return Long
     * */
    public Long getId(){
        return this.id;
    }

    /** Установить имя объекта
     * @param s имя
     * */
    public void setName(String s){
        this.name = s;
    }

    /** Получить значение поля name
     * @see Movie#setName(String)
     * @return String
     * */
    public String getName(){
        return this.name;
    }

    /** Установить значение поля coordinates
     * @param coordinates объект класса Coordinates
     * @see Coordinates
     * */
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    /** Метод возвращает значение поля coordinates объекта
     * @return Coordinates
     * @see Coordinates
     * */
    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    /** Установить значение поля creationDate
     * @param localDate дата создания объекта
     * @see LocalDateTime
     * */
    public void setCreationDate(LocalDateTime localDate){
        this.creationDate = localDate;
    }

    /** Метод возвращает значение поля creationDate
     * @see LocalDateTime
     * @return LocalDateTime
     * */
    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    /** Установить значение поля oscarsCount
     * @param c количество оскаров
     * @see Long
     * */
    public void setOscarsCount(Long c){
        this.oscarsCount = c;
    }

    /** Метод возвращает значение поля oscarsCount
     * @see Long
     * @return Long
     * */
    public Long getOscarsCount(){
        return this.oscarsCount;
    }

    /** Установить значение поля goldenPalmCount
     * @param c количество золотых пальм
     * @see Long
     * */
    public void setGoldenPalmCount(Long c){
        this.goldenPalmCount = c;
    }

    /** Метод возвращает значение поля goldenPalmCount
     * @see Long
     * @return Long
     * */
    public long getGoldenPalmCount(){
        return this.goldenPalmCount;
    }

    /** Установить значение поля genre
     * @param g объект класса MovieGenre
     * @see MovieGenre
     * */
    public void setGenre(MovieGenre g){
        this.genre = g;
    }

    /** Метод возвращает значение поля genre
     * @return MovieGenre
     * @see MovieGenre
     * */
    public MovieGenre getGenre(){
        return this.genre;
    }

    /** Установить значение поля mpaaRating
     * @param mpaaRating объект класса MpaaRating
     * @see MpaaRating
     * */
    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /** Метод возвращает значение поля mpaaRating
     * @return MpaaRating
     * @see MpaaRating
     * */
    public MpaaRating getMpaaRating() {
       return this.mpaaRating;
    }

    /** Установить значение поля operator
     * @param operator объект класса Person
     * @see Person
     * */
    public void setOperator(Person operator) {
        this.operator = operator;
    }

    /** Метод возвращает значение поля operator
     * @return Person
     * @see Person
     * */
    public Person getOperator() {
        return this.operator;
    }

    /** Базовый компаратор класса (сравнивает объекты по значению поля "id")
     * @param o объект класса
     * */
    @Override
    public int compareTo(Object o){
        Movie movie = (Movie) o;
        return (int)(this.id - movie.id);
    }

    /** Метод возвращающий объект класса в виде строки
     * @return String
     * @see String
     * */
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.getCoordinates() +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", goldenPalmCount=" + goldenPalmCount +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", operator=" + '{' + operator.getName() + ";" + operator.getHeight() + ";" +
                operator.getEyeColor() + ";" + operator.getHairColor() + "}}";
    }
}