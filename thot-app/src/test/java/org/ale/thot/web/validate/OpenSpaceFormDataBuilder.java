package org.ale.thot.web.validate;

import org.ale.thot.model.OpenSpaceFormData;

/**
 * Created by adi on 8/21/14.
 */
public class OpenSpaceFormDataBuilder {
    private OpenSpaceFormData openSpaceFormData;
    private String title = "Correct title";
    private String speaker = "@someValidName";

    public OpenSpaceFormDataBuilder valid() {
	openSpaceFormData = new OpenSpaceFormData();
	openSpaceFormData.setSpeaker(speaker);
	openSpaceFormData.setTitle(title);
	return this;
    }

    public OpenSpaceFormDataBuilder withTitle(String title) {
	this.title = title;
	return this;
    }

    public OpenSpaceFormDataBuilder withSpeaker(String speaker) {
	this.speaker = speaker;
	return this;
    }

    public OpenSpaceFormData build() {
	openSpaceFormData = new OpenSpaceFormData();
	openSpaceFormData.setSpeaker(speaker);
	openSpaceFormData.setTitle(title);
	return openSpaceFormData;
    }
}