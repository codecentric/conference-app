package org.ale.thot.selenium.pages;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.jbehave.web.selenium.SeleniumPage;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public abstract class AbstractPage extends SeleniumPage {

	String basePath = "";

    public AbstractPage(Selenium selenium, ConditionRunner conditionRunner, String basePath) {
        super(selenium, conditionRunner);
        this.basePath = basePath;
    }

    
    
    
	@Override
	public void open(String url) {
		super.open(basePath+url);
	}








	public void found(String text) {
        textIsVisible(text);
    }

    public void found(List<String> texts) {
        for (String text : texts) {
            found(text);
        }
    }

    public void notFound(String text) {
        textIsNotVisible(text);
    }

	public String getHeadline() {
		return getText("xpath=//h1");
	}

	public void assertExpectedTitle() {
		assertEquals(getExpectedHeadline(), getHeadline());
	}

	protected String getExpectedHeadline() {
		return "no expected headline given for this page class";
	}

}
