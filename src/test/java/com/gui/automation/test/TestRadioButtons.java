package com.gui.automation.test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class TestRadioButtons extends AbstractLaunchChromeBrowser {

	@Test
	public void getRadioButtons() {
		Logger logger = LogManager.getLogger(TestRadioButtons.class);

		test = report.createTest("Radio Buttons Test").assignAuthor("Yogesh").assignCategory("Smoke");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice page is launched");
		driver.manage().window().maximize();

		setRadioOption("//input[@name='radioButton']", "radio3");
		sleep(2);

		WebElement radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		assertTrue(radio3.isSelected());
		logger.info("Radio option3 is selected and validated successfully");

		readRadioOptionValues("//input[@name='radioButton']");

	}

	public void setRadioOption(String xpath, String optionvalue) {
		List<WebElement> listOfRadioOptions = driver.findElements(By.xpath(xpath)); // "//input[@name='radioButton']"

		for (WebElement radio : listOfRadioOptions) {
			if (radio.getAttribute("value").equals(optionvalue)) {
				radio.click();
			}
		}
	}

	public void readRadioOptionValues(String xpath) {
		List<WebElement> listOfRadioOptions = driver.findElements(By.xpath(xpath)); // "//input[@name='radioButton']"

		for (WebElement radio : listOfRadioOptions) {
			System.out.println(radio.getAttribute("value"));
		}
	}

}
