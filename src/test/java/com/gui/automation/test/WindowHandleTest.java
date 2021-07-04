package com.gui.automation.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class WindowHandleTest extends AbstractLaunchChromeBrowser {
	@Test
	public void getWindowHandles() throws IOException {

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		String firstwindowHandle = driver.getWindowHandle();

		driver.findElement(By.id("openwindow")).click();

		String secondwindowhandle = findSecondWindowHandle(firstwindowHandle);

		driver.switchTo().window(secondwindowhandle);
		String expectedTitle = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";

		takesScreenshot("./target/");

		assertEquals(driver.getTitle(), expectedTitle);

	}

	public void takesScreenshot(String dest) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyymmddhhmmss'.png'").format(new Date());
		String path = dest + fileName;
		FileUtils.copyFile(screenshot, new File(path));
	}

	public String findSecondWindowHandle(String firstwindowHandle) {

		for (String handle : driver.getWindowHandles()) {

			if (!firstwindowHandle.equals(handle)) {
				return handle;
			}
		}
		return null;
	}
}
