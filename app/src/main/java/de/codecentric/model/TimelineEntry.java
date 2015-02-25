package de.codecentric.model;

import de.codecentric.util.TwitterLinkCreator;

public class TimelineEntry {

    private String date;
    private String user;
    private String comment;
    private String sessionId;
    private String sessionTitle;

    public TimelineEntry(String date, String user, String comment, String sessionId, String sessionTitle) {
        super();
        this.date = date;
        this.user = user;
        this.comment = comment;
        this.sessionId = sessionId;
        this.sessionTitle = sessionTitle;
    }

    public String getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getProcessedUser() {
        return TwitterLinkCreator.process(user);
    }

    public String getComment() {
        return comment;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

}
