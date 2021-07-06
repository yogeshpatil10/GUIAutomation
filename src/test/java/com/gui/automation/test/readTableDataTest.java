package com.gui.automation.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automate.web.firstcode.AbstractLaunchChromeBrowser;

public class readTableDataTest extends AbstractLaunchChromeBrowser {
	@Test
	public void readFromTableTest() {
		Logger logger = LogManager.getLogger(readTableDataTest.class);
		test = report.createTest("Read Data From Web Table Test");

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Launched automation practice page");
		driver.manage().window().maximize();

		TableReader reader = new TableReader(driver, "product");
		logger.info("Reading table elements from Web Table");
		System.out.println(reader.getReader(2, 2));
		System.out.println(reader.getReader(5, 3));

		// TableReader reader2 = new TableReader(driver,"")

		// WebElement tbody = driver.findElement(By.cssSelector("#product > tbody"));

		// "#product > tbody > tr:nth-child(2) > td:nth-child(2)"
		// WebElement element22 = tbody.findElement(By.cssSelector("tr:nth-child(2) >
		// td:nth-child(2)"));

		// #product > tbody > tr:nth-child(5) > td:nth-child(3)"
		// WebElement element53 = tbody.findElement(By.cssSelector("tr:nth-child(5) >
		// td:nth-child(3)"));

		List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr"));
		for (WebElement row : allRows) {
			System.out.println(row.getText());
		}

		TableReaderOfFixedHeaders readerOfFixedHeadres = new TableReaderOfFixedHeaders(driver, "tableFixHead");

		logger.info("Reading table elements from Web Table");

		System.out.println(readerOfFixedHeadres.getReaderOfFixedHeaders(2, 4));
		System.out.println(readerOfFixedHeadres.getReaderOfFixedHeaders(4, 2));
		System.out.println(readerOfFixedHeadres.getReaderOfFixedHeaders(5, 1));

		String nameOf5thPersonInTable = readerOfFixedHeadres.getReaderOfFixedHeaders(5, 1);

		assertEquals(nameOf5thPersonInTable, "Jack");
		logger.info("Person name is valdated successfully from Web table");

		// WebElement tbodyOfFixedHeaderTable =
		// driver.findElement(By.cssSelector(".tableFixHead>table>tbody"));

		// WebElement element24 =
		// tbodyOfFixedHeaderTable.findElement(By.cssSelector("tr:nth-child(2)>td:nth-child(4)"));
	}
}
