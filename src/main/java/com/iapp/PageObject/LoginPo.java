package com.iapp.PageObject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ParameterizationUtil;
import utilities.SeleniumHelpers;

public class LoginPo 
{
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement Username ;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement Password;
	@FindBy(xpath="//input[@type=\"button\"]")private WebElement LoginButton;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/p[1]")private WebElement ErrorMessage;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/p[1]")private WebElement ErrorMessageWithNoDataprovided;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/img[1]")private WebElement companylogo;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/img[1]")private WebElement logoOfAcessControl;
	@FindBy(xpath="//div[contains(text(),'Access Control')]")private WebElement textofAcessControl;
	@FindBy(xpath="//div[@class='pages-deatil-block']//div[2]//div[1]//img[1]")private WebElement logoOfVisitorManagement ;
	@FindBy(xpath="//div[contains(text(),'Visitor Management')]")private WebElement textOfVisitorManagement ;
	@FindBy(xpath="//div[3]//div[1]//img[1]")private WebElement logoOfAtendanceManagement ;
	@FindBy(xpath="//div[contains(text(),'Attendance Management')]")private WebElement textOfAtendanceManagement ;
	@FindBy(xpath="//div[4]//div[1]//img[1]")private WebElement LogoOfCanteenManagement;
	@FindBy(xpath="//input[@id='chkRememberme']")private WebElement Checkbox ;
//	@FindBy(xpath="")private WebElement  ;

	SeleniumHelpers selenium;
	public LoginPo(WebDriver driver) 
	{	   
		PageFactory.initElements(driver,this);
		selenium= new SeleniumHelpers(driver);	
	}


	public void EnterCredentials() throws IOException 
	{
		selenium.enterText(Username,ParameterizationUtil.readPropertyFile("un"),true);
		selenium.enterText(Password,ParameterizationUtil.readPropertyFile("pwd"), true);
	}
	public void ClickONLoginButton() throws InterruptedException 
	{
		selenium.click(LoginButton);
	}
	public void EnterInvalidCredentials() throws IOException 
	{
		selenium.enterText(Username,ParameterizationUtil.readPropertyFile("UN"),true);
		selenium.enterText(Password,ParameterizationUtil.readPropertyFile("PWD"),true);
	}
	public String IsErrorMessageDisplayed() 
	{
		return selenium.getText(ErrorMessage);
	}
	public String IsErrorMessageDisplayedForNodataProvided() throws InterruptedException 
	{
		selenium.click(LoginButton);
		return selenium.getText(ErrorMessageWithNoDataprovided);
	}
	public boolean validateCompanyLogo()
	{
		return selenium.isElementPresent(companylogo);

	}
	public boolean validateLogoOfAcessControl()
	{
		return selenium.isElementPresent(logoOfAcessControl);
	}
	public String validateTextOfAcessControl()
	{
		return selenium.getText(textofAcessControl);
	}
	public boolean checkBoxIsByDefaultNotSelected() 
	{
		return selenium.isCheckboxSelected(Checkbox);
	}
	public boolean IscheckBoxSelected()
	{
		selenium.checkbox(Checkbox, true);
		return selenium.isCheckboxSelected(Checkbox);
	}
}
