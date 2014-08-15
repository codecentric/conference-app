package org.ale.thot.selenium.pages;

import static junit.framework.Assert.assertEquals;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class SpeakerPage extends AbstractPage {

	
	public SpeakerPage(Selenium selenium, ConditionRunner conditionRunner, String basePath) {
		super(selenium, conditionRunner, basePath);
	}

	public void fillField(String field, String value) {
		type("id=" + field, value);
	}

	public void clickSaveButton() {
		click("id=saveSpeaker");
	}
	
	protected String getExpectedHeadline() {
		return "Speaker";
	}

	public void assertFieldValue(String field, String expectedValue) {
		assertEquals("value of field " + field, expectedValue, value("id=" + field));
	}

	public SpeakersPage toSpeakersPage() {
		return new SpeakersPage(selenium, conditionRunner, basePath);
	}

	public String getEmailValidationError() {
		return getText("id=mail.errors");
	}

}
