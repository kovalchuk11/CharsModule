package model;

public class Place {
    private int id;
    private String data;
    private int sick;
    private int dead;
    private String abbreviation;
    private String placeName;

    public Place() {
    }

    public Place(int id, String data, int sick, int dead, String abbreviation, String placeName) {
        this.id = id;
        this.data = data;
        this.sick = sick;
        this.dead = dead;
        this.abbreviation = abbreviation;
        this.placeName = placeName;
    }

    public int getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getData() {
        return data;
    }

    public int getSick() {
        return sick;
    }

    public int getDead() {
        return dead;
    }

}
