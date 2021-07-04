package com.gui.automation.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class TextAreaTest extends AbstractLaunchChromeBrowser {

	@Test
	public void textArearTest() throws IOException {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement textArea = driver.findElement(By.id("autocomplete"));
		assertTrue(textArea.getAttribute("value").equals(""));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementById('autocomplete').value='SomeText'");

		takesScreenshot("./target/");

		String value = textArea.getAttribute("value");
		System.out.println(value);
		assertTrue(textArea.getAttribute("value").equals("SomeText"));

	}

	@Test
	public void javaScriptExecutorTest() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title");
		System.out.println(title);
		js.executeScript("window.scrollBy(0,200)");
		sleep(2);
		js.executeScript("window.scrollBy(0,200)");
		sleep(2);
		js.executeScript("window.scrollBy(0,200)");
		sleep(2);
	}

	public void takesScreenshot(String dest) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyymmddhhmmss'.png'").format(new Date());

		String path = dest + fileName;
		FileUtils.copyFile(screenshot, new File(path));
	}
}
