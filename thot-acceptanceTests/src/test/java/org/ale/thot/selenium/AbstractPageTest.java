package org.ale.thot.selenium;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractPageTest {

	private static String serverUrl = "http://localhost:9080/thot-app";
	private static final String SYSTEM_PROPERTY = "server.url";
	private String baseUrl;
	
	protected WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = System.getProperty(SYSTEM_PROPERTY);
		if (StringUtils.isEmpty(baseUrl)) {
			baseUrl = serverUrl;
		}
	}

	@Test
	public void openPageAndValidateTitle() {
		open("/feedback");
		String PAGE_TITLE = "Open Space Software Development - ALE 2014";
		assertTrue("Page title does not match", PAGE_TITLE.equalsIgnoreCase(driver.getTitle()));
	}
	
	@After
	public void tearDownWebDriver() {
		driver.close();
	}

	protected void open(String url) {
		driver.navigate().to(baseUrl + url);
	}

}