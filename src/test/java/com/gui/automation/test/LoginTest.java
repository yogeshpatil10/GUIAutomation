package com.gui.automation.test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class LoginTest extends AbstractLaunchChromeBrowser {
	@Test
	public void loginPageTest() {
		Logger logger = LogManager.getLogger(LoginTest.class);

		test = report.createTest("Login Test").assignAuthor("Yogesh").assignCategory("Smoke");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice page is launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
