package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Pages {

    private StaticSessions staticSessions;
    
	private Selenium selenium;
	private ConditionRunner conditionRunner;
	
	String basePath = "";

	public Pages(Selenium selenium,ConditionRunner conditionRunner, String basePath) {
		this.selenium = selenium;
		this.conditionRunner = conditionRunner;
		this.basePath = basePath;
	}


	
	public StaticSessions staticSessions() {
        if (staticSessions == null) {
            staticSessions = new StaticSessions(selenium,conditionRunner,basePath);
        }
        return staticSessions;
    }
	

}
