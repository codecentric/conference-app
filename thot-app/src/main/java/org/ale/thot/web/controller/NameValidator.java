package org.ale.thot.web.controller;

import static org.ale.app.TwitterLinkCreator.TWITTER_NAME_PATTERN;

import org.ale.app.INameValidator;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidator implements INameValidator {
    @Override
    public Boolean isValid(String speaker) {
	if (speaker.isEmpty())
	    return false;

	return TWITTER_NAME_PATTERN.matcher(speaker).matches();
    }
}
