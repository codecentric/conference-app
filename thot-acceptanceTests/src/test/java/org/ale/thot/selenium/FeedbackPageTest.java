package org.ale.thot.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeedbackPageTest extends AbstractPageTest {
	
	@Test
	public void openFeedbackPage(){
		open("/feedback");
		WebElement title = driver.findElement(By.id("title"));
		assertTrue(title.isDisplayed());
	}

}