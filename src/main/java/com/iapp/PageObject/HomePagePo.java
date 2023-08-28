package com.iapp.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumHelpers;

public class HomePagePo {

	
	@FindBy(xpath="//img[@id='User']")private WebElement MyProfile;
	@FindBy(xpath="//a[@id='lblogout']")private WebElement LogOut;
	@FindBy(xpath="//i[@class='icon-attendance']")private WebElement AttendanceManagementicon;
//	@FindBy(xpath="((//ul[@class='nav child_menu'])[10])/li")private WebElement AttendanceManagementiconAllOption;
	@FindBy(xpath="(//a[text()='Leave'])[2]")private WebElement Leave;
	@FindBy(xpath="//a[normalize-space()='Shift & Leave Types']")private WebElement ShiftAndleaveType;
	@FindBy(xpath="//a[normalize-space()='Leave Application']")private WebElement LeaveApplication;
	@FindBy(xpath="//input[@id='btnCreate']")private WebElement NewButton;
	SeleniumHelpers selenium;
	public HomePagePo(WebDriver driver) 
	{	   
		PageFactory.initElements(driver,this);
		selenium= new SeleniumHelpers(driver);	
	}
	public void clickOnMyProfile() throws InterruptedException
	{
		selenium.click(MyProfile);
	}
	public void clickOnLogOutButton() throws InterruptedException
	{
		selenium.click(LogOut);
	}
	public void clickOnAttendanceManagementicon() throws InterruptedException
	{
		selenium.clickOn(AttendanceManagementicon);

	}
	public void clickOnLeaveOption() throws InterruptedException
	{  
		selenium.click(Leave);
	}
    public void GetAllOptionsOfAttendanceManagement(WebDriver driver) 
    {
      List<WebElement> Elements = driver.findElements(By.xpath("((//ul[@class='nav child_menu'])[10])/li"));
      for(WebElement temp:Elements)
      {
    	System.out.println(temp.getText()); 
      }
    }
      public void ClickOnLeavApplication() throws InterruptedException
      {
    	  selenium.clickOn(LeaveApplication);
      }
    public Boolean NewButtonIsPresent()
    {
    	return selenium.isElementPresent(NewButton);
    	
    }
    


}

