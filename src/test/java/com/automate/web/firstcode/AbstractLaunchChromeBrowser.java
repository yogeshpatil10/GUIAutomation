package com.automate.web.firstcode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractLaunchChromeBrowser {

	// If you change instance variables to static variables, you should use it with
	// ThreadLocal
	// so that it will not create any problem while running in parallel.

	protected static WebDriver driver;

	public AbstractLaunchChromeBrowser() {
		super();
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			// Download the Web Driver executable.
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			// Get the instance of the Web Driver.
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = new FirefoxOptions();
			options1.setHeadless(true);
			driver = new FirefoxDriver(options1);

		} else {
			System.out.println("Invalid browser");
		}

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
