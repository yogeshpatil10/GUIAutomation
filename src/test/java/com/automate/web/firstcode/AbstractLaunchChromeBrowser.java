package com.automate.web.firstcode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractLaunchChromeBrowser {

	// If you change instance variables to static variables, you should use it with
	// ThreadLocal
	// so that it will not create any problem while running in parallel.

	protected static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;

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

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Host Name", "DESKTOP-9SGE8AP");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Yogesh Patil");
		report.setSystemInfo("Java Version", "15.0.1");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlReporter.config().setReportName("My Own Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void tearDown() {
		report.flush();
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
