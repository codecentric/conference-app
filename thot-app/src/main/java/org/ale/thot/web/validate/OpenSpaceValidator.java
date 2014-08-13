package org.ale.thot.web.validate;

import org.ale.thot.model.OpenSpaceFormData;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class OpenSpaceValidator {

	public static void validate(OpenSpaceFormData formData, Errors errors) {
		if ( formData.getTitle() == null || formData.getTitle().isEmpty() ) {
			ValidationUtils.rejectIfEmpty (errors, "title", null, "Title cannot be empty!");
		}
	}
}
