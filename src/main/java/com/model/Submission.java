package com.model;

public class Submission {
    private String title;
    private String description;
    private String contentType;
    private String thumbnailUrl;

    public Submission() {
    }

    public Submission(String title, String description, String contentType, String thumbnailUrl) {
        this.title = title;
        this.description = description;
        this.contentType = contentType;
        this.thumbnailUrl = thumbnailUrl;
    }

    // Getters and Setters for the properties

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
