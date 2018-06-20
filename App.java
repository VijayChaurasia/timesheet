package com.qait.automation.hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class App 
{	            
	    WebDriver driver;
	    public App(WebDriver driver)
	    {
	    	this.driver=driver;
	    }
	    private WebElement getUserNameEntry(){
	        return this.driver.findElement(By.id("txtUserName"));
	    }
	    
	    private WebElement getPasswordEntry(){
	        return this.driver.findElement(By.id("txtPassword"));
	}
	    private WebElement getErrorMessageElement(){
	        return this.driver.findElement(By.cssSelector(".alert-error"));
	}
	    public String loginWithIncorrectCredentials(String username, String password){
	        login(username, password);
	        return getErrorMessageElement().getText();
	        
	}
	    public Timesheet loginWithCorrectCredentials(String username, String password){
	        login(username, password);
	        return new Timesheet(driver);
	}
	    public void login(String username,String password)
	    {
	    	 getUserNameEntry().clear();
	         getUserNameEntry().sendKeys(username);
	         getPasswordEntry().clear();
	         getPasswordEntry().sendKeys(password);
	         getPasswordEntry().submit();
	    }
	    public Boolean isErrorMessage(String expectedMessage){
	        return getErrorMessageElement().getText()
	                .contains(expectedMessage);
	    }
	    
	    public Boolean isPasswordEntryAnnotated(){
	        return getPasswordEntry().getAttribute("style").contains("red");
	}
	    
	    

}
