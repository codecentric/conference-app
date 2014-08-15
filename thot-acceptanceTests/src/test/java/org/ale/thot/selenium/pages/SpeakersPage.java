package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class SpeakersPage extends AbstractPage {
	
	

	public SpeakersPage(Selenium selenium, ConditionRunner conditionRunner, String basePath) {
		super(selenium, conditionRunner, basePath);
	}

	public void open() {
		open("/speakers");
	}

	public SpeakerPage clickSaveSpeakerButton() {
		click("id=addSpeaker");
		return speakerPage();
	}

	private SpeakerPage speakerPage() {
		return new SpeakerPage(selenium, conditionRunner, basePath);
	}
	
	protected String getExpectedHeadline() {
		return "Speakers";
	}

	public SpeakerPage clickSpeaker(String foreName, String lastName) {
		click(speakerLocator(foreName, lastName));
		return speakerPage();
	}

	public boolean speakerExists(String foreName, String lastName) {
		return isElementPresent(speakerLocator(foreName, lastName));
	}
	
	private String speakerLocator(String foreName, String lastName) {
		return "id=speaker" + foreName + lastName;
	}

}
