package com.qait.automation.hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Timesheet {
	WebDriver driver;
	public Timesheet(WebDriver driver)
	{
		this.driver=driver;
	}
	public String verify_page()
	{
//		
		String icon=driver.findElement(By.id("dvSearchBox")).getAttribute("class");
		return icon;
		
	}
	public boolean issucessfullogin()
	{
		String att=verify_page();
		return att.equals("search-box");
	}
	
	

}
