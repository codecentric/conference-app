package org.ale.thot.web.validate;

import static org.ale.app.TwitterLinkCreator.TWITTER_NAME_PATTERN;

import org.ale.thot.model.OpenSpaceFormData;
import org.springframework.validation.Errors;

public class OpenSpaceValidator {

	public static void validate(OpenSpaceFormData formData, Errors errors) {
		if ( formData.getTitle() == null || formData.getTitle().isEmpty() ) {
            errors.rejectValue("title", null, "Title cannot be empty!");
		}

		String speaker = formData.getSpeaker();
        if( speaker == null
                ||
            (speaker != null && (speaker.startsWith("@") || !TWITTER_NAME_PATTERN.matcher(speaker).matches() ))) {
        	errors.rejectValue("speaker", null, "Speaker twitter name is incorrect");
        }

	}
}
