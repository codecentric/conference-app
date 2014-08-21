package org.ale.thot.web.controller;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidatorTests {
    @Test
    public void nameIsNotValidWhenEmpty(){
        NameValidator nameValidator = new NameValidator();
        String emptySpeaker = "";

        assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenNotStartingWithAt(){
        NameValidator nameValidator = new NameValidator();
        String emptySpeaker = "@";

        assertFalse(nameValidator.isValid(emptySpeaker));
    }
}
