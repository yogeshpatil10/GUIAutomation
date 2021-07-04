package com.gui.automation.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class ExplicitWaitElementTest extends AbstractLaunchChromeBrowser {
	@Test
	public void checkElementVisibility() {

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		WebElement hideText = driver.findElement(By.id("hide-textbox"));
		hideText.click();
		WebElement textbox = driver.findElement(By.id("displayed-text"));
		assertFalse(textbox.isDisplayed());

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement showText = driver.findElement(By.id("show-textbox"));
		showText.click();
		WebElement textboxShowed = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("displayed-text"))));
		assertTrue(textboxShowed.isDisplayed());
		textboxShowed.sendKeys("Text written");

	}
}
