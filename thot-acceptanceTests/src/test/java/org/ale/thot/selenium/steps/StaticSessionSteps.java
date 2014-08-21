package org.ale.thot.selenium.steps;

import org.ale.thot.selenium.pages.Pages;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StaticSessionSteps {
	
    private final Pages pages;

    public StaticSessionSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on sessions page")
    public void userIsOnHomePage(){        
        pages.staticSessions().open();
    }

    @When("user opens sessions today")
    public void userClicksOnFindSteps(){        
        pages.staticSessions().open();
    }
    
    @Then("sessions today is shown")
    public void findStepsPageIsShown(){
    	pages.staticSessions().checkIfCurrentSessionsAreShown();
    }

}
