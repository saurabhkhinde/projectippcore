package com.iapp.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumHelpers;

public class LeaveApllicationPo{
     
	@FindBy(xpath="//input[@id='btnCreate']")private WebElement New;
	@FindBy(xpath="(//input[@type='button'])[3]")private WebElement submitButton;
	@FindBy(xpath="(//a[@class=\"select2-choice\"])[1]")private WebElement Location;
	@FindBy(xpath="//input[@id='s2id_autogen6_search']")private WebElement LocationSearchBox;
	@FindBy(xpath="//input[@id='emp']")private WebElement EmployeeName;
	@FindBy(xpath="(//a[@class=\"select2-choice\"])[2]")private WebElement UserType ;
	@FindBy(xpath="(//input[@role=\"combobox\"])[10]")private WebElement  UserTypeSearchBox;
	@FindBy(xpath="(//a[@class=\"select2-choice\"])[5]") private WebElement Lookup ;
	@FindBy(xpath="(//input[@role=\"combobox\"])[10]")private WebElement LookupSearchbox;
	@FindBy(xpath="(//a[@class=\"select2-choice\"])[6]")private WebElement Select;
	@FindBy(xpath="(//input[@autocapitalize=\"off\"])[10]")private WebElement SelectSearchBox;
//	@FindBy(xpath="")private WebElement ;
	
	SeleniumHelpers selenium;
	public LeaveApllicationPo(WebDriver driver) 
	{	   
		PageFactory.initElements(driver,this);
		selenium= new SeleniumHelpers(driver);	
	}
	public void clickOnNewButton() throws InterruptedException
	{
		selenium.clickOn(New);
	}
	public Boolean SubmitButtonIsPresent()
    {
    	return selenium.isElementPresent(submitButton);
    	
    }
	public void selectLocation(String location) throws InterruptedException
	{
		selenium.clickOn(Location);
		selenium.enterText(LocationSearchBox,location , true);
		selenium.Enter();		
	}
    public void EnterEmployeeName() throws InterruptedException
    {
    	selenium.click(EmployeeName);
    }
    public void EnterUserType(String Usertype)throws InterruptedException
    {
    	selenium.clickOn(UserType);
		selenium.enterText(UserTypeSearchBox,Usertype , true);
		selenium.Enter();		
    }
 
    public void EnterLookupType(String lookup)throws InterruptedException
    {
    	selenium.click(Lookup);
		selenium.enterText(LookupSearchbox,lookup , true);
		selenium.Enter();		
    }
  
    public void EnterSelectType(String select)throws InterruptedException
    {
    	selenium.clickOn(Select);
    	
		selenium.enterText(SelectSearchBox,select, true);
		selenium.Enter();		
    }
}
