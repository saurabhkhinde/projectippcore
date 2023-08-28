package com.iapp.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.iapp.PageObject.HomePagePo;
import com.iapp.PageObject.LoginPo;
import com.iapp.base.BasePo;

public class HomePageTest extends BasePo {
	LoginPo login;
	HomePagePo home;
	@Test(priority=1)
	public void verifyclickOnAttendanceManagement() throws InterruptedException, IOException
	{
		BrowserLaunch();
		 login= new LoginPo(driver);
		 login.EnterCredentials();
		 login.ClickONLoginButton();
		 home= new HomePagePo(driver);
		 home.clickOnAttendanceManagementicon();
		 home.GetAllOptionsOfAttendanceManagement(driver);
	}
	@Test(priority=2)
      public void verifyClickOnLeaveOptionSelect() throws InterruptedException
      {
		
		home.clickOnLeaveOption();
		home.ClickOnLeavApplication();
    	
      }
	@Test(priority=3)
	public void VerifyUseIsNavigateToLeaveApplicationPage()
	{
		
		Assert.assertTrue(home.NewButtonIsPresent(),"User is not able to navigate on Leav Application page");
	    
	}
	
	  @AfterClass
	    public void BrowserClose() 
	    {
	    	
	    	driver.quit();
	    }
}
