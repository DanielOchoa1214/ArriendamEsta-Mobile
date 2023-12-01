package edu.eci.arriendamestamobile.model;

public class Petition {

    private String id;
    private boolean acepted;
    private String content;
    private String authorId;
    private String ownerId;
    private String propertyId;

    public Petition(String id, boolean acepted, String content, String authorId, String ownerId, String propertyId) {
        this.id = id;
        this.acepted = acepted;
        this.content = content;
        this.authorId = authorId;
        this.ownerId = ownerId;
        this.propertyId = propertyId;
    }

    public Petition() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAcepted() {
        return acepted;
    }

    public void setAcepted(boolean acepted) {
        this.acepted = acepted;
    }

    public String getContent() {
        return content;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }
}
