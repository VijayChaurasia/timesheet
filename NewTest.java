package com.qait.automation.hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.automation.hris.App;

public class NewTest {
  WebDriver driver;
  
  App loginForm;
  Timesheet time;
  @Test(priority=2)
  public void issuccessfullogin()
  {
	  /*loginForm.login("vijayprakash","Vijay@321#");
	  String actual=driver.getTitle();
	  String expected="QAIT Resource Management Tool";
	  Assert.assertEquals(actual, expected);
	   */
	  Timesheet time=loginForm.loginWithCorrectCredentials("vijayprakash","Vijay@321#");
	  this.time=time;
//	  try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	  Assert.assertTrue(time.issucessfullogin());
	  
  }
  @Test(priority=0)
  public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(){
      Assert.assertTrue(loginForm
              .loginWithIncorrectCredentials("INVALID_USERN", "INVALUD_PASSWEOR").contains("Invalid Login"));
  }
  
  @Test(priority=1)
  public void attempt_Login_With_No_Password_Should_Annotate_Black_Password_Field(){
      loginForm.login("vijay", "");
      // red border in password entry
      Assert.assertTrue(loginForm.isPasswordEntryAnnotated());  
}
 /* @Test(priority=3)
  public void reached_timesheet()
  {
	  time=new Timesheet(driver);
	 
	  String expicon=driver.findElement(By.className("seach-icon")).getAttribute("class");
	  String acticon=time.verify_page();
	  Assert.assertEquals(expicon,acticon);
	 
  }
  */
  
  @BeforeClass
  public void launchBrowser(){
      driver = new ChromeDriver();
      driver.get("https://hris.qainfotech.com/login.php");
      loginForm = new App(driver);
  }
  
  @AfterClass
  public void closeBrowser(){
     driver.quit();
  }
}