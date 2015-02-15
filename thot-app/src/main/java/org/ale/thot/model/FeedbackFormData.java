package org.ale.thot.model;

public class FeedbackFormData {

    private String name;
    private String feedbackContent;

    public String getFeedbackContent() {
	return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
	this.feedbackContent = feedbackContent;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
