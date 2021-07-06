package com.gui.automation.test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class CheckBoxOptionsTest extends AbstractLaunchChromeBrowser {

	@Test
	public void checkBoxOptionsTest() {

		Logger logger = LogManager.getLogger(CheckBoxOptionsTest.class);
		test = report.createTest("CheckBox Options Test");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice page is launched");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger.info("Selecting a checkbox if not selected");

		checkACheckBox("checkBoxOption1");
		checkACheckBox("checkBoxOption2");
		checkACheckBox("checkBoxOption3");

	}

	public void checkACheckBox(String checkBoxOptionId) {
		WebElement checkBoxOption1 = driver.findElement(By.id(checkBoxOptionId));
		boolean selected = checkBoxOption1.isSelected();
		if (selected == false) {
			checkBoxOption1.click();
		}
	}
}
