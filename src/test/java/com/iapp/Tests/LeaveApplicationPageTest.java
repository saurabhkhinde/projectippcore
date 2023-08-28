package com.iapp.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.iapp.PageObject.HomePagePo;
import com.iapp.PageObject.LeaveApllicationPo;
import com.iapp.PageObject.LoginPo;
import com.iapp.base.BasePo;

import utilities.ParameterizationUtil;

public class LeaveApplicationPageTest extends BasePo {
	LoginPo login;
	HomePagePo home;
	LeaveApllicationPo lp;
	@Test
	public void VerifyUserIsNavigateToLeaveApllicationForm() throws InterruptedException, IOException
	{
		BrowserLaunch();
		login=new LoginPo(driver);
		login.EnterCredentials();
		login.ClickONLoginButton();
		home=new HomePagePo(driver);
		home.clickOnAttendanceManagementicon();
		home.clickOnLeaveOption();
		home.ClickOnLeavApplication();
		lp=new LeaveApllicationPo(driver);
		lp.clickOnNewButton();
		Assert.assertTrue(lp.SubmitButtonIsPresent(),"user is unable to navigate to login application form ");
	}
	@Test(priority=1)
	public void VerifyUserIsAbleToSelectLocation() throws InterruptedException, EncryptedDocumentException, IOException
	{
		lp.selectLocation(ParameterizationUtil.excelStringData("sheet1",2,1));

	}
	@Test(priority=2)
	public void VerifyUserIsAbleToSelectEmployeeName() throws InterruptedException, EncryptedDocumentException, IOException
	{
		lp.EnterEmployeeName();
		lp.EnterUserType(ParameterizationUtil.excelStringData("sheet1",2,2));

	}
	@Test(priority=3)
	public void VerifyUserIsAbleToSelectLookup() throws InterruptedException, EncryptedDocumentException, IOException
	{

		lp.EnterLookupType(ParameterizationUtil.excelStringData("sheet1",4,3));

	}
	@Test(priority=4)
	public void VerifyUserIsAbleToSelect() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		lp.EnterSelectType(ParameterizationUtil.excelStringData("sheet1",2,4));

	}


	@AfterClass
	public void BrowserClose() 
	{
		
		driver.quit();
	}








}
