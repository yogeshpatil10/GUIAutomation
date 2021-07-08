package com.gui.automation.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class ExplicitWaitElementTest extends AbstractLaunchChromeBrowser {
	@Test
	public void checkElementVisibility() {
		Logger logger = LogManager.getLogger(ExplicitWaitElementTest.class);

		test = report.createTest("Explicit Wait on Element Test").assignAuthor("Yogesh").assignCategory("Smoke");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice Page is launched");
		driver.manage().window().maximize();

		WebElement hideText = driver.findElement(By.id("hide-textbox"));
		hideText.click();
		logger.info("hitext textbox clicked");
		WebElement textbox = driver.findElement(By.id("displayed-text"));
		assertFalse(textbox.isDisplayed());
		logger.info("Validated that textbox is not displayed");

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement showText = driver.findElement(By.id("show-textbox"));
		showText.click();
		logger.info("showText text box clicked");
		WebElement textboxShowed = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("displayed-text"))));
		assertTrue(textboxShowed.isDisplayed());
		textboxShowed.sendKeys("Text written");

	}
}
