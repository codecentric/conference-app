package org.ale.thot.selenium.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Timeline extends AbstractPage {

    public Timeline(Selenium selenium, ConditionRunner conditionRunner, String basePath) {
        super(selenium, conditionRunner, basePath);
    }

	public void open() {
        open("/timeline");
    }

}
