package org.ale.thot.selenium.steps;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.pages.SpeakerPage;
import org.ale.thot.selenium.pages.SpeakersPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SpeakerSteps {

	private Pages pages;
	private SpeakerPage speakerPage;
	private SpeakersPage speakersPage;

	public SpeakerSteps(Pages pages) {
		this.pages = pages;
	}

	@Given("user is on the speaker creation page")
	public void userIsOnTheSpeakerPage() {
		userIsOnSpeakersSite();

		speakerPage = speakersPage.clickSaveSpeakerButton();
		speakerPage.assertExpectedTitle();
	}

	@When("user sets forename '$foreName'")
	public void userAddsForename(String foreName) {
		speakerPage.fillField("foreName", foreName);
	}

	@When("user sets last name '$lastName'")
	public void userAddsLastName(String lastName) {
		speakerPage.fillField("lastName", lastName);
	}

	@When("user sets the bio '$bio'")
	public void userAddsTheBio(String bio) {
		speakerPage.fillField("bio", bio);
	}

	@When("user saves the speaker")
	public void userSavesTheSpeaker() {
		speakerPage.clickSaveButton();
	}

	@Then("user is on the speaker creation page")
	public void userIsOnTheSpeakerCreationPage() {
		speakerPage.assertExpectedTitle();
	}

	@Then("a speaker exists with forename '$foreName', last name '$lastName' and bio '$bio'")
	public void aSpeakerExistsWith(String foreName, String lastName, String bio) {
		aSpeakerExistsOnSpeakersPage(foreName, lastName);
		speakerPage.assertExpectedTitle();
		speakerPage.assertFieldValue("foreName", foreName);
		speakerPage.assertFieldValue("lastName", lastName);
		speakerPage.assertFieldValue("bio", bio);
	}

	private void aSpeakerExistsOnSpeakersPage(String foreName, String lastName) {
		speakersPage.open();
		speakersPage.assertExpectedTitle();

		userSelectsSpeakerWith(foreName, lastName);
	}

	@Given("user is on speakers site")
	public void userIsOnSpeakersSite() {
		speakersPage = pages.speakers();
		speakersPage.open();
		speakersPage.assertExpectedTitle();
	}

	@Given("user selects speaker with forename '$foreName' and with last name '$lastName'")
	public void userSelectsSpeakerWith(String foreName, String lastName) {
		assertTrue(speakersPage.speakerExists(foreName, lastName));
		speakerPage = speakersPage.clickSpeaker(foreName, lastName);
	}

	@Then("a speaker with forename '$foreName' and with last name '$lastName' does not exist")
	public void aSpeakerDoesNotExistsWith(String foreName, String lastName) {
		assertFalse("speaker should not exist",
				speakersPage.speakerExists(foreName, lastName));
	}

	@Then("e-mail is valid")
	public void emailIsValid() {
		speakersPage = speakerPage.toSpeakersPage();
		speakersPage.assertExpectedTitle();
	}

	@Then("e-mail validation error is '$message'")
	public void emailValidationError(String message) {
		assertEquals("expected validation error message", message,
				speakerPage.getEmailValidationError());
	}

	@When("user sets the e-mail-address '$mail'")
	public void userSetsTheEmailAddressTo(String mail) {
		speakerPage.fillField("mail", mail);
	}


	// prepared steps:
	// And user sets the e-mail-address 'david@voelkel.de'
	// And user sets the e-mail-address 'david.korrigiert@voelkel.de'

}
