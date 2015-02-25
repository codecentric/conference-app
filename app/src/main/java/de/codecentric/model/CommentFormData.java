package de.codecentric.model;

public class CommentFormData {

    private String author;
    private String text;
    private Long sessionId;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String sessionTitle) {
        this.title = sessionTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

}
