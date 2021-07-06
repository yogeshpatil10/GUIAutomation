package com.gui.automation.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class TestTitleOfThePage extends AbstractLaunchChromeBrowser {

	@Test
	public void getTitleOfPage() {
		Logger logger = LogManager.getLogger(TestTitleOfThePage.class);

		test = report.createTest("Title Of The Page Test");

		// driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice page is launched");
		driver.manage().window().maximize();

		sleep(2);

		String title = driver.getTitle();

		assertEquals(title, "Practice Page");
		logger.info("Page title has been validated successfully");

	}
}
