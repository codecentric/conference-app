package org.cc.thot.web.validate.impl;

import static org.cc.thot.util.TwitterLinkCreator.TWITTER_NAME_PATTERN;

import org.cc.thot.web.validate.NameValidator;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidatorImpl implements NameValidator {

    @Override
    public boolean isValid(String speaker) {

	if (speaker.isEmpty()) {
	    return false;
	}

	return TWITTER_NAME_PATTERN.matcher(speaker).matches();
    }

}
