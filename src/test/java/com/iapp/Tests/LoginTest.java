package com.iapp.Tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.iapp.PageObject.HomePagePo;
import com.iapp.PageObject.LoginPo;
import com.iapp.base.BasePo;

public class LoginTest extends BasePo
{
	LoginPo login;
	HomePagePo home;
    String ExpectedErrorMessage="Invalid Username/Password!";
    String ExpectedErrorMessageForNoDataProvided="Provide Username and Password";
    
    
    @BeforeClass
   
	public void BrowserOpen() throws InterruptedException, IOException 
	{
    	Reporter.log("Step 1- Navigate to url");
    	BrowserLaunch();
	    login= new LoginPo(driver);
	    home= new HomePagePo(driver);
	}
    @Test(priority=1)
    public void VerifyLogoIsDisplayed()
    {
    	Reporter.log("Step 2- Verify logo is displayed on login page");
    	boolean result=login.validateCompanyLogo();
		Assert.assertTrue(result,"Logo is not displayed");

    }
    @Test(priority=2)
    public void VerifyAcessControlLogoIsDisplayed()
    {    
    	Reporter.log("Step 3- Verify AcessControl module logo");
     	boolean result=login.validateLogoOfAcessControl();
    	Assert.assertTrue(result,"Logo is not displayed");
    }
  
    @Test(priority=3)
    public void VerifyErrorMessageforNoDataProvided() throws InterruptedException
    {
    	Reporter.log("Step 4- verify error message is shown for no data provided when click on login");
    	login.ClickONLoginButton();
    	Assert.assertEquals(login.IsErrorMessageDisplayedForNodataProvided(),ExpectedErrorMessageForNoDataProvided,"Error message does not matched with expected");
    	Thread.sleep(5000);
    }
	@Test(priority=6)
	public void VerifyErrorMessageAfterEnterInvalidCredential() throws IOException, InterruptedException
    {     
		Reporter.log("Step 5-Verify error massage is shown when click on login button by providing invalid credantial. ");
		login.EnterInvalidCredentials();
		login.ClickONLoginButton();
    	Assert.assertEquals(login.IsErrorMessageDisplayed(),ExpectedErrorMessage);    	
    }
    @Test(dependsOnMethods="VerifyErrorMessageAfterEnterInvalidCredential") 
	public void VerifyUserLoginSuccessfully() throws IOException, InterruptedException
	{
    	Reporter.log("Step 6- Verify user is able to login sussfully");
		login.EnterCredentials();
		login.ClickONLoginButton();
		home.clickOnMyProfile();
		home.clickOnLogOutButton();
	}
    @Test(priority=4)
   public void VerifyCheckBoxIsByDefaultNotSelected()
   {	 Reporter.log("Step 7- verify chechbox is bydefault select or not");
	   Assert.assertFalse(login.checkBoxIsByDefaultNotSelected(),"checkBox is alredy selected");
   }
    @Test(priority=5)
   public void verifyCheckBoxIsSelected()
   {
    	Reporter.log("Step 8- verify checkbox is able to select");
	    Assert.assertTrue(login.IscheckBoxSelected(),"user unable to select checkbox");
   }
   
    @AfterClass
    public void BrowserClose() 
    {
    	Reporter.log("Step 9- close all tab of browser");
    	driver.quit();
    }
}
