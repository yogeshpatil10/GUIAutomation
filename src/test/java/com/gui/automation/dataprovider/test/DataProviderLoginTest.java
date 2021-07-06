package com.gui.automation.dataprovider.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class DataProviderLoginTest extends AbstractLaunchChromeBrowser {

	@DataProvider(name = "user-ids-passwords-dataprovider")
	public Object[][] userIdsPasswordsDataProvider() {

		return new Object[][] { { "in28minutes", "dummy", true }, { "adam", "adam@123", true },
				{ "adam", "12345", false }, { "eve", "eve@123", true }, { "eve", "123", false } };

	}

	@Test(dataProvider = "user-ids-passwords-dataprovider")
	@Ignore

	public void successfulLoginDataProvider(String username, String pass, boolean isLoginToBeSuccessful) {
		driver.get("http://localhost:8080/login");
		// sleep(5);
		WebElement userid = driver.findElement(By.id("name"));
		userid.clear();
		userid.sendKeys(username);
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(pass);

		driver.findElement(By.id("submit")).submit();

		if (isLoginToBeSuccessful) {

			String welcomemsg = driver.findElement(By.id("welcome-message")).getText();
			System.out.println(welcomemsg);
			assertTrue(welcomemsg.contains("Welcome " + username));
			driver.findElement(By.linkText("Logout")).click();
		} else {

			String errortext = driver.findElement(By.id("error-message")).getText();
			assertTrue(errortext.contains("Invalid Credentials"));
		}

	}
}
