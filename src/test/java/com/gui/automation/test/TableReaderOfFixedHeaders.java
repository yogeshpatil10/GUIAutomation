package com.gui.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableReaderOfFixedHeaders {

	private WebDriver driver;
	private String classname;
	private WebElement tbodyOfFixedHeaderTable;

	public TableReaderOfFixedHeaders(WebDriver driver, String classname) {
		this.driver = driver;
		this.classname = classname;
		tbodyOfFixedHeaderTable = driver.findElement(By.cssSelector("." + classname + ">table>tbody"));
	}

	public String getReaderOfFixedHeaders(int row, int col) {
		return tbodyOfFixedHeaderTable
				.findElement(By.cssSelector("tr:nth-child(" + row + ")>td:nth-child(" + col + ")")).getText();

	}

}
