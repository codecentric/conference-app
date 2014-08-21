package org.ale.thot.web.validate;

import org.ale.thot.model.OpenSpaceFormData;
import org.junit.Assert;
import org.junit.Before;
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

    OpenSpaceFormDataBuilder openSpaceFormDataBuilder;
    OpenSpaceFormData formData;

    @Before
    public void setup(){
        openSpaceFormDataBuilder = new OpenSpaceFormDataBuilder();
    }

    @Test
    public void returnErrorWhenTitleIsNull(){
        String nullTitle = null;
        formData = openSpaceFormDataBuilder.withTitle(nullTitle).build();
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("title", null, "Title cannot be empty!");
    }

    @Test
    public void returnErrorWhenTitleIsEmpty(){
        String emptyTitle = "";
        formData = openSpaceFormDataBuilder.withTitle(emptyTitle).build();
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("title", null, "Title cannot be empty!");
    }


    @Test
    public void returnErrorWhenSpeakerNameIsNull(){
        String speaker = null;
        formData = openSpaceFormDataBuilder.withSpeaker(speaker).build();
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameIsEmpty(){
        String emptySpeakerName = "@";
        formData = openSpaceFormDataBuilder.withSpeaker(emptySpeakerName).build();
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameContainsPipe(){
        formData = openSpaceFormDataBuilder.withSpeaker("@adi|adi").build();
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }

    @Test
    public void returnErrorWhenSpeakerNameDoesNotStartWithAt(){

        formData = openSpaceFormDataBuilder.withSpeaker("notStartingWith@").build();
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        verify(errors).rejectValue("speaker", null, "Speaker twitter name is incorrect");
    }
}