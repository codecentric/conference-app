package org.cc.thot.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.cc.thot.web.controller.NameValidator;
import org.junit.Test;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidatorTests {

    @Test
    public void nameValidWhenContainsNumbers() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@243";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameValidWhenContainsLowerCaseLetters() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@validname";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameValidWhenContainsUpperCaseLetters() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@ValidName";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameValidWhenContainsUnderscore() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@some_name";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameNotValidWhenContainsDash() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@some-name";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenEmpty() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenNotStartingWithAt() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenContainsSpace() {
	NameValidator nameValidator = new NameValidator();
	String emptySpeaker = "@some name";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }
}