package org.ale.thot.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CurrentSessionsPagesTest extends AbstractPageTest {

	@Test
	public void openCurrentSessionsPage() {
		open("/currentSessions");
		WebElement title = driver.findElement(By.id("title"));
		assertTrue(title.isDisplayed());
	}

}