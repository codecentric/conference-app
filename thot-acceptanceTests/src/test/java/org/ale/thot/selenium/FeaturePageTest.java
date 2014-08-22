package org.ale.thot.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeaturePageTest extends AbstractPageTest {

	@Test
	public void openFeaturePage() {
		open("/features.jsp");
		WebElement title = driver.findElement(By.id("title"));
		assertTrue(title.isDisplayed());
	}

}