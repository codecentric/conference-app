package de.codecentric.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.codecentric.web.validate.impl.NameValidatorImpl;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidatorTests {

    @Test
    public void nameValidWhenContainsNumbers() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@243";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameValidWhenContainsLowerCaseLetters() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@validname";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameValidWhenContainsUpperCaseLetters() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@ValidName";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameValidWhenContainsUnderscore() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@some_name";

	assertTrue(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameNotValidWhenContainsDash() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@some-name";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenEmpty() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenNotStartingWithAt() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenContainsSpace() {
	NameValidatorImpl nameValidator = new NameValidatorImpl();
	String emptySpeaker = "@some name";

	assertFalse(nameValidator.isValid(emptySpeaker));
    }
}