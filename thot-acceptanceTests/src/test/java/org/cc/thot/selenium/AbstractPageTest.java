package org.cc.thot.selenium;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractPageTest {

	private static String serverUrl = "http://localhost:9080/thot";
	private static final String SYSTEM_PROPERTY = "server.url";
	private String baseUrl;
	
	protected WebDriver driver;
	protected String PAGE_TITLE = "Hackerspace - JavaLand 2015";
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = System.getProperty(SYSTEM_PROPERTY);
		if (StringUtils.isEmpty(baseUrl)) {
			baseUrl = serverUrl;
		}
	}

	@After
	public void tearDownWebDriver() {
		driver.close();
	}

	protected void open(String url) {
		driver.navigate().to(baseUrl + url);
	}

}