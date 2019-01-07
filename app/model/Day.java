package model;




import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Clase que mapea el objecto Day
 */
public class Day {

    @MongoObjectId
    private String _id;
    private int date;
    private String weather;

    public Day() {

    }

    public Day(int date, String weather) {
        this.date = date;
        this.weather = weather;
    }

    public int getDate() {
        return date;
    }

    public void setDay(int date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
