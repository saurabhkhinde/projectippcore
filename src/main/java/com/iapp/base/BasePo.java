package com.iapp.base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.ParameterizationUtil;

public class BasePo {

	protected static WebDriver driver;

	public static void BrowserLaunch() throws InterruptedException, IOException
	{			
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(ParameterizationUtil.readPropertyFile("url"));
	}

	
}
