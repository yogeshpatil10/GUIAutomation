package com.gui.automation.csvreader;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readCSVTest {

	@DataProvider(name = "read-data-csv")
	public Iterator<String[]> csvDataProviderMethod() {
		return CSVFrameWorkMethod(".\\src\\test\\resources\\login-data.csv").iterator();
	}

	@Test
	@Ignore
	public void readDataFromCSV() throws IOException {
		List<String[]> data = CSVFrameWorkMethod(".\\src\\test\\resources\\login-data.csv");
		for (String[] row : data) {
			System.out.println(Arrays.toString(row));
		}

	}

	public List<String[]> CSVFrameWorkMethod(String csvFilePath) {
		try {
			CSVReader csvreader = new CSVReader(new FileReader(csvFilePath));
			List<String[]> data = csvreader.readAll();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Test(dataProvider = "read-data-csv")
	@Ignore
	public void logindataFromCSV(String username, String pass, String isLoginToBeSuccessfulString) {

		boolean isLoginToBeSuccessful = Boolean.valueOf(isLoginToBeSuccessfulString);

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);

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
