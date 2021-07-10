package com.gui.automation.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class AlertPopUpTest extends AbstractLaunchChromeBrowser {

	// Just added comment for Git purpose.

	@Test
	public void alertBoxTest() {

		Logger logger = LogManager.getLogger(AlertPopUpTest.class);

		test = report.createTest("Alert Test").assignAuthor("Yogesh").assignCategory("Smoke");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		logger.info("Sending name as Yogesh");
		WebElement alertTextBox = driver.findElement(By.name("enter-name"));
		alertTextBox.sendKeys("Yogesh");

		sleep(4);

		logger.info("Sending name as Patil");
		Actions actions = new Actions(driver);
		actions.sendKeys(alertTextBox, " Patil").perform();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("alertbtn")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		sleep(5);

		System.out.println(alert.getText());

		assertEquals(alert.getText(), "Hello Yogesh Patil, share this practice page and share your knowledge");

		alert.accept();
	}
}
