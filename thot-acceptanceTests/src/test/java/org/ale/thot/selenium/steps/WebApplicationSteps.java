package org.ale.thot.selenium.steps;

import org.ale.thot.selenium.pages.Pages;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class WebApplicationSteps {
	
    private final Pages pages;

    public WebApplicationSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.staticSessions().open();
    }

    @When("user opens timeline")
    public void userClicksOnTimeline(){        
        pages.timeline().open();
    }
    
    @When("user opens sessions today")
    public void userClicksOnFindSteps(){        
        pages.staticSessions().open();
    }
    
    @Then("timeline is shown")
    public void timelineIsShown(){
    }

    
    @Then("sessions today is shown")
    public void findStepsPageIsShown(){
    }

}
