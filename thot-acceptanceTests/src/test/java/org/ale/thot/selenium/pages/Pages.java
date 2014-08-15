package org.ale.thot.selenium.pages;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Pages {

    private StaticSessions staticSessions;
    private Timeline timeline;
    
	private Selenium selenium;
	private ConditionRunner conditionRunner;
	private SpeakersPage speakers;
	
	String basePath = "";

	public Pages(Selenium selenium,ConditionRunner conditionRunner, String basePath) {
		this.selenium = selenium;
		this.conditionRunner = conditionRunner;
		this.basePath = basePath;
	}

	public Timeline timeline() {
        if (timeline == null) {
            timeline = new Timeline(selenium,conditionRunner, basePath);
        }
        return timeline;
    }

	
	public StaticSessions staticSessions() {
        if (staticSessions == null) {
            staticSessions = new StaticSessions(selenium,conditionRunner,basePath);
        }
        return staticSessions;
    }
	
	public SpeakersPage speakers() {
		if (speakers == null) {
			speakers = new SpeakersPage(selenium, conditionRunner, basePath);
		}
		return speakers;
	}

}
