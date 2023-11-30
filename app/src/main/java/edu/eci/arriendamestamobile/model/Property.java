package edu.eci.arriendamestamobile.model;

public class Property {

    private String id;
    private String location;
    private String description;
    private int squareMeters;
    private int price;
    private String title;
    private String homeOwnerId;
    private String stateProperty;

    public Property(String id, String location, String description, int squareMeters, int price, String title, String homeOwnerId, String stateProperty) {
        this.id = id;
        this.location = location;
        this.description = description;
        this.squareMeters = squareMeters;
        this.price = price;
        this.title = title;
        this.homeOwnerId = homeOwnerId;
        this.stateProperty = stateProperty;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Property() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHomeOwnerId(String homeOwnerId) {
        this.homeOwnerId = homeOwnerId;
    }

    public void setStateProperty(String stateProperty) {
        this.stateProperty = stateProperty;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public String getTitle() {
        return title;
    }

    public String getHomeOwnerId() {
        return homeOwnerId;
    }

    public String getStateProperty() {
        return stateProperty;
    }
}
