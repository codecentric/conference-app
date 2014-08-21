package org.ale.thot.web.validate;

import org.ale.thot.model.OpenSpaceFormData;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by adi on 8/21/14.
 */
public class OpenSpaceValidatorTests {
    @Test
    public void returnErrorWhenTitleIsNull(){
        OpenSpaceFormData formData = new OpenSpaceFormData();
        String nullTitle = null;
        formData.setTitle(nullTitle);
        String validTwitterName = "@someValidName";
        formData.setSpeaker(validTwitterName);
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("title", null, "Title cannot be empty!");
    }

    @Test
    public void returnErrorWhenTitleIsEmpty(){
        OpenSpaceFormData formData = new OpenSpaceFormData();
        String emptyTitle = "";
        formData.setTitle(emptyTitle);
        String validTwitterName = "@someValidName";
        formData.setSpeaker(validTwitterName);
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("title", null, "Title cannot be empty!");
    }


    @Test
    public void returnErrorWhenSpeakerNameIsNull(){
        OpenSpaceFormData openSpaceFormData = new OpenSpaceFormData();
        openSpaceFormData.setTitle("non empty title");
        openSpaceFormData.setSpeaker(null);
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(openSpaceFormData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameIsEmpty(){
        OpenSpaceFormData openSpaceFormData = new OpenSpaceFormData();
        openSpaceFormData.setTitle("non empty title");
        openSpaceFormData.setSpeaker("@");
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(openSpaceFormData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameContainsPipe(){
        OpenSpaceFormData openSpaceFormData = new OpenSpaceFormData();
        openSpaceFormData.setTitle("non empty title");
        openSpaceFormData.setSpeaker("@adi|adi");
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(openSpaceFormData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameDoesNotStartWithAt(){
        OpenSpaceFormData openSpaceFormData = new OpenSpaceFormData();
        openSpaceFormData.setTitle("non empty title");
        openSpaceFormData.setSpeaker("doesNotStartWith@");
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(openSpaceFormData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }
}
