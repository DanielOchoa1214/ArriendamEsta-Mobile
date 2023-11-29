package edu.eci.arriendamestamobile.model;

public class Property {
    private String id;
    private String location;
    private int price;
    private String description;
    private int squareMeters;
    private String title;
    private String stateProperty;
    private String homeOwnerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStateProperty() {
        return stateProperty;
    }

    public void setStateProperty(String stateProperty) {
        this.stateProperty = stateProperty;
    }

    public String getHomeOwnerId() {
        return homeOwnerId;
    }

    public void setHomeOwnerId(String homeOwnerId) {
        this.homeOwnerId = homeOwnerId;
    }
}
