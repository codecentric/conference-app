package de.codecentric.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FeedbackPageTest extends AbstractPageTest {
	
	private String pageLink = "/feedback";
	
	@Test
	public void openPageAndValidateTitle() {
		open(pageLink);
		assertTrue("Page title does not match", PAGE_TITLE.equalsIgnoreCase(driver.getTitle()));
	}
	
	@Test
	public void openFeedbackPage(){
		open(pageLink);
		WebElement title = driver.findElement(By.className("panel-title"));
		assertTrue(title.isDisplayed());
	}

  @Test
  public void feedbackOutputIsSanitized() {
    open(pageLink);
    String dangerousUserContent = "<script>alert('I hacked you');</script>";
    driver.findElement(By.id("feedbackContent")).sendKeys(dangerousUserContent);
    driver.findElement(By.id("name")).sendKeys(dangerousUserContent);
    driver.findElement(By.id("addFeedback")).click();
    open(pageLink);
    List<WebElement> comments = driver.findElements(By.className("feedback-comment"));
    boolean foundSanitizedComment = false;
    for (WebElement comment : comments) {
      foundSanitizedComment = foundSanitizedComment || comment.getText().equals(dangerousUserContent);
    }
    assertTrue(foundSanitizedComment);
    boolean foundSanitizedUserName = false;
    List<WebElement> userNamesAndTimestamps = driver.findElements(By.className("username-and-timestamp"));
    for (WebElement userNameAndTimestamp : userNamesAndTimestamps) {
      foundSanitizedUserName = foundSanitizedUserName || userNameAndTimestamp.getText().contains(dangerousUserContent);
    }
  }

}