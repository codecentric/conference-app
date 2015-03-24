package de.codecentric.validate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.codecentric.validate.impl.NameValidatorImpl;

/**
 * Created by adi on 8/21/14.
 */
public class NameValidatorTests {

    @Test
    public void nameValidWhenContainsNumbers() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String nameWithNumbers = "@243";

        assertTrue(nameValidator.isValid(nameWithNumbers));
    }

    @Test
    public void nameValidWhenContainsLowerCaseLetters() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String nameOnlyLowerCase = "@validname";

        assertTrue(nameValidator.isValid(nameOnlyLowerCase));
    }

    @Test
    public void nameValidWhenContainsUpperCaseLetters() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String nameUpperAndLowerCase = "@ValidName";

        assertTrue(nameValidator.isValid(nameUpperAndLowerCase));
    }

    @Test
    public void nameValidWhenContainsUnderscore() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String nameUnderscore = "@some_name";

        assertTrue(nameValidator.isValid(nameUnderscore));
    }

    @Test
    public void nameNotValidWhenContainsDash() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String nameDash = "@some-name";

        assertFalse(nameValidator.isValid(nameDash));
    }

    @Test
    public void nameIsNotValidWhenEmpty() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String emptySpeaker = "";

        assertFalse(nameValidator.isValid(emptySpeaker));
    }

    @Test
    public void nameIsNotValidWhenOnlyWithAt() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String onlyAt = "@";

        assertFalse(nameValidator.isValid(onlyAt));
    }

    @Test
    public void nameIsNotValidWhenContainsSpace() {
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        String nameWithSpace = "@some name";

        assertFalse(nameValidator.isValid(nameWithSpace));
    }
}