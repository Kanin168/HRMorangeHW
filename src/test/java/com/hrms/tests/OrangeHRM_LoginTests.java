 package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.testBase.ConfigsReader;
import com.hrms.testBase.Driver;

public class OrangeHRM_LoginTests {

	
	//1. login using the valid credentials, and user should be able to successfully login and see the dashboard/landing page
	//2. try loging in using a valid username and invalid password, and user should see "Invalid credentials"
	
	
	// 3. invalid username,  valid password
	// 4. invalid username, invalid passord
	// 5. blank username , valid password
	// 6. valid username, blank password
	
	@BeforeMethod (alwaysRun = true)
	public void beforeClass() {
		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod() {
		Driver.getDriver().close();
	}
	
	
	
	
	
	@Test(priority = 0, description = "Loging in with valid Username and password", groups = { "login" })
	public void Login_ValidUsername_ValidPassword() {
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userNameId")))
				.sendKeys(ConfigsReader.getProperty("validUserName"));
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passWordId")))
				.sendKeys(ConfigsReader.getProperty("validPassWord"));
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButtonId"))).click();
		String welcomeText = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("welcomeTextId")))
				.getText();
		String expectedWelcomeText = "Welcome Paul";
		Assert.assertEquals(welcomeText, expectedWelcomeText);
	}
	@Test(priority = 0, groups = { "login" })
	public void Login_validUsername_InvalidPassword() {
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userNameId")))
				.sendKeys(ConfigsReader.getProperty("validUserName"));
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passWordId")))
				.sendKeys(ConfigsReader.getProperty("invalidPassword"));
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButtonId"))).click();
		String invalidCredentialMessage = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("spanMessageError")))
				.getText();
		String expectedCredentialMessage = "Invalid credentials";
		Assert.assertEquals(invalidCredentialMessage, expectedCredentialMessage);
	}
	
	
	@Test 
	public void longReporTesting() {
		Reporter.log("Testing ");
		Reporter.log("Testing again will get 100K ");
	}
	
	
	
	
	
	
	
	
	
	
	
}
