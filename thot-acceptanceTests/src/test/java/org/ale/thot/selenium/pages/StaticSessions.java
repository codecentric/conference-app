package org.ale.thot.selenium.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class StaticSessions extends AbstractPage {

    public StaticSessions(Selenium selenium, ConditionRunner conditionRunner, String basePath) {
        super(selenium, conditionRunner, basePath);
    }

	public void open() {
        open("/staticSessions");
    }
	
	public void checkIfCurrentSessionsAreShown(){
		isElementPresent("current_sessions");
	}

}
