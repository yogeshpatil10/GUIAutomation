package com.gui.automation.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class TestTitleOfThePage extends AbstractLaunchChromeBrowser {

	@Test
	public void getTitleOfPage() {

		// driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		sleep(2);

		String title = driver.getTitle();

		assertEquals(title, "Practice Page");

	}
}
