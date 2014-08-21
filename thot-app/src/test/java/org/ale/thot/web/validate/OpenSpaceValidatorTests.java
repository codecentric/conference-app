package org.ale.thot.web.validate;

import org.ale.thot.model.OpenSpaceFormData;
import org.junit.Assert;
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

/**
 * Created by adi on 8/21/14.
 */
public class OpenSpaceValidatorTests {
    @Test
    public void something(){
        OpenSpaceFormData formData = new OpenSpaceFormData();
        String validTwitterName = "@adi";
        formData.setSpeaker(validTwitterName);
        Errors errors = mock(Errors.class);

        OpenSpaceValidator.validate(formData, errors);

        assertTrue(errors.getAllErrors().isEmpty());
    }

    @Test
    public void somethingElse(){
        OpenSpaceFormData openSpaceFormData = new OpenSpaceFormData();
        openSpaceFormData.setSpeaker("some speaker");
        String emptyTitle = "";
        openSpaceFormData.setTitle(emptyTitle);
        BindingResult bindingResult = mock(BindingResult.class);

        OpenSpaceValidator.validate(openSpaceFormData, bindingResult);

        assertTrue(bindingResult.hasErrors());
    }


}
