package com.gui.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class LoginTest extends AbstractLaunchChromeBrowser {
	@Test
	public void loginPageTest() {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
