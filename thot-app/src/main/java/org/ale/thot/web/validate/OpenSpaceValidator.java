package org.ale.thot.web.validate;

import static org.ale.app.TwitterLinkCreator.TWITTER_NAME_PATTERN;

import org.ale.thot.model.OpenSpaceFormData;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class OpenSpaceValidator {

	public static void validate(OpenSpaceFormData formData, Errors errors) {
		if ( formData.getTitle() == null || formData.getTitle().isEmpty() ) {
			ValidationUtils.rejectIfEmpty(errors, "title", null, "Title cannot be empty!");
		}

		String speakter = formData.getSpeaker();
        if( speakter == null
                ||
            (speakter != null && (speakter.startsWith("@") || !TWITTER_NAME_PATTERN.matcher(speakter).matches() ))) {
        	errors.rejectValue("speaker", null, "Speaker twitter name is incorrect");
        }

	}
}
