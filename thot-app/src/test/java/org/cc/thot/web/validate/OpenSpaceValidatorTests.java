package org.cc.thot.web.validate;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.cc.app.INameValidator;
import org.cc.thot.model.OpenSpaceFormData;
import org.cc.thot.web.validate.OpenSpaceValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Errors;

/**
 * Created by adi on 8/21/14.
 */
public class OpenSpaceValidatorTests {

    OpenSpaceFormDataBuilder openSpaceFormDataBuilder;
    OpenSpaceFormData formData;
    private OpenSpaceValidator openSpaceValidator;
    INameValidator nameValidatorStub;

    @Before
    public void setup() {
	openSpaceFormDataBuilder = new OpenSpaceFormDataBuilder();
	openSpaceValidator = new OpenSpaceValidator();
	nameValidatorStub = mock(INameValidator.class);
	openSpaceValidator.nameValidator = nameValidatorStub;
    }

    @Test
    public void returnErrorWhenTitleIsNull() {
	String nullTitle = null;
	formData = openSpaceFormDataBuilder.valid().withTitle(nullTitle).build();
	Errors errors = mock(Errors.class);

	openSpaceValidator.validate(formData, errors);

	verify(errors).rejectValue("title", null, "Title cannot be empty!");
    }

    @Test
    public void returnErrorWhenTitleIsEmpty() {
	String emptyTitle = "";
	formData = openSpaceFormDataBuilder.valid().withTitle(emptyTitle).build();
	Errors errors = mock(Errors.class);

	openSpaceValidator.validate(formData, errors);

	verify(errors).rejectValue("title", null, "Title cannot be empty!");
    }

    @Test
    public void returnErrorWhenSpeakerNameIsNull() {
	String speaker = null;
	formData = openSpaceFormDataBuilder.valid().withSpeaker(speaker).build();
	Errors errors = mock(Errors.class);

	openSpaceValidator.validate(formData, errors);

	verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameIsInvalidForTwitter() {
	String invalidNameForTwitter = "invalidNameForTwitter";
	formData = openSpaceFormDataBuilder.valid().withSpeaker(invalidNameForTwitter).build();
	when(nameValidatorStub.isValid(anyString())).thenReturn(false);
	Errors errorsMock = mock(Errors.class);

	openSpaceValidator.validate(formData, errorsMock);

	verify(errorsMock).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }
}