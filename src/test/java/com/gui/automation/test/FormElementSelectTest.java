package com.gui.automation.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class FormElementSelectTest extends AbstractLaunchChromeBrowser {

	@Test
	public void selectOptionFromDropDwon() {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(selectElement);
		select.selectByIndex(0);
		System.out.println(select.getFirstSelectedOption());
		System.out.println(select.isMultiple());
		select.selectByValue("option2");
		select.selectByVisibleText("Option3");

		for (WebElement element : select.getAllSelectedOptions()) {

			System.out.println("selected option: " + element.getText());
		}

		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}
}
