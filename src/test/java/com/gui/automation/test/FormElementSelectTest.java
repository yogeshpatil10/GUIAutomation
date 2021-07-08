package com.gui.automation.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class FormElementSelectTest extends AbstractLaunchChromeBrowser {

	@Test
	public void selectOptionFromDropDwon() {
		Logger logger = LogManager.getLogger(FormElementSelectTest.class);
		test = report.createTest("Form Elements Select Test").assignAuthor("Yogesh").assignCategory("Smoke");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice page is launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(selectElement);

		select.selectByIndex(0);
		logger.info("First element selcted from drop-down");

		logger.info("Getting element selcted from drop-down: ");
		System.out.println(select.getFirstSelectedOption());

		logger.info("Checking if drop-down is a multi-select: ");
		System.out.println(select.isMultiple());

		select.selectByValue("option2");
		logger.info("Selected drop-down element by value");
		select.selectByVisibleText("Option3");
		logger.info("Selected drop-down element by visible text");

		logger.info("Printing all seclected options");
		for (WebElement element : select.getAllSelectedOptions()) {

			System.out.println("selected option: " + element.getText());
		}

		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}
}
