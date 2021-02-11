package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
 
import com.hrms.testBase.ConfigsReader;
import com.hrms.testBase.Driver;

public class loginTest {

	LoginPageElements loginPageObject = new LoginPageElements();
	DashboardPageElements dashBoardObject = new DashboardPageElements();
	@BeforeMethod
	public void setUp() {

		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTestUsingPOM() {

		loginPageObject.username.sendKeys(ConfigsReader.getProperty("validUsername"));
		loginPageObject.password.sendKeys(ConfigsReader.getProperty("validPassword"));
		loginPageObject.loginBtn.click();
		
		System.out.println(dashBoardObject.subscriberLinkText.getAttribute("value"));
		Assert.assertEquals(dashBoardObject.subscriberLinkText.getAttribute("value"), "Subscribe");
		 
	}
	
	
	
	

}
