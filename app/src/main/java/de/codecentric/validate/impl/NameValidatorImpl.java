package de.codecentric.validate.impl;

import de.codecentric.util.TwitterLinkCreator;
import de.codecentric.validate.NameValidator;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidatorImpl implements NameValidator {

    @Override
    public boolean isValid(String speaker) {

        if (speaker.isEmpty()) {
            return false;
        }

        return TwitterLinkCreator.TWITTER_NAME_PATTERN.matcher(speaker).matches();
    }

}
