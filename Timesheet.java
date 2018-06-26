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
	public WebElement verify_page()
	{
		try {
			Thread.sleep(1000);
			System.out.println("sleeping");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
	/*	String icon=driver.findElement(By.id("dvSearchBox")).getAttribute("class");
		return icon;*/
		WebElement element=driver.findElement(By.className("emp_time"));
		return element;
		
	}
	/*public boolean issucessfullogin()
	{
		String att=verify_page();
		return att.equals("search-box");
	}
	*/
	

}
